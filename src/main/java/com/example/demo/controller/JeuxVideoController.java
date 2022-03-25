package com.example.demo.controller;

import com.example.demo.controller.model.CreateJeuxVideo;
import com.example.demo.controller.model.JeuxVideoResponse;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.JeuxVideoDao;
import com.example.demo.dao.entity.JeuxVideo;
import com.example.demo.service.JeuxVideoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilderException;
import java.util.ArrayList;
import java.util.List;

@Path("/jeuxVideos")
public class JeuxVideoController {

    private static final List<JeuxVideo> jeuxVideos = new ArrayList<>();

    @Inject
    JeuxVideoService jeuxVideoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<JeuxVideoResponse> jeuxVideoResponses = jeuxVideoService.fetchAll();
        return Response.ok(jeuxVideoResponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAlbum(CreateJeuxVideo createJeuxVideo) throws UriBuilderException {

        JeuxVideo jeuxVideo = new JeuxVideo(createJeuxVideo.getTitle(), createJeuxVideo.getReleaseDate(), createJeuxVideo.getQuantity());
        JeuxVideoDao jeuxVideoDao = DaoFactory.getJeuxVideoDao();
        jeuxVideoDao.save(jeuxVideo);
        return Response.status(201).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        DaoFactory.getJeuxVideoDao().delete(id);
        return Response.ok(jeuxVideos).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(JeuxVideo jeuxVideo) {
        boolean isUpdate = DaoFactory.getJeuxVideoDao().update(jeuxVideo);
        if (isUpdate) return Response.status(204).build();
        return Response.status(404)
                .entity("Le jeu video exist pas")
                .build();
    }
}
