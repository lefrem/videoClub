package com.example.demo.controller;

import com.example.demo.controller.model.AlbumResponse;
import com.example.demo.controller.model.CreateAlbum;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.AlbumDao;
import com.example.demo.dao.entity.Album;
import com.example.demo.service.AlbumService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilderException;
import java.util.ArrayList;
import java.util.List;

@Path("/albums")
public class AlbumController {
    private static final List<Album> albums = new ArrayList<>();

    @Inject
    AlbumService albumService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<AlbumResponse> albumResponses = albumService.fetchAll();
        return Response.ok(albumResponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAlbum(CreateAlbum createAlbum) throws UriBuilderException {

        Album album = new Album(createAlbum.getTitle(), createAlbum.getDuration(), createAlbum.getReleaseDate(), createAlbum.getQuantity());
        AlbumDao albumDao = DaoFactory.getAlbumDao();
        albumDao.save(album);
        return Response.status(201).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        DaoFactory.getAlbumDao().delete(id);
        return Response.ok(albums).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Album album) {
        boolean isUpdate = DaoFactory.getAlbumDao().update(album);
        if (isUpdate) return Response.status(204).build();
        return Response.status(404)
                .entity("L'album' exist pas")
                .build();
    }

}