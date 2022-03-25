package com.example.demo.controller;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.MovieDao;
import com.example.demo.controller.model.CreateMovie;
import com.example.demo.controller.model.MovieResponse;
import com.example.demo.dao.entity.Movie;
import com.example.demo.service.MovieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilderException;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MovieController {
    private static final List<Movie> movies = new ArrayList<>();

    @Inject
    MovieService movieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<MovieResponse> movieResponses = movieService.fetchAll();
        return Response.ok(movieResponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMovie(CreateMovie createMovie) throws UriBuilderException {

        Movie movie = new Movie(createMovie.getTitle(), createMovie.getDuration(), createMovie.getReleaseDate(), createMovie.getQuantity());
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.save(movie);
        return Response.status(201).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        DaoFactory.getMovieDao().delete(id);
        return Response.ok(movies).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Movie movie) {
        boolean isUpdate = DaoFactory.getMovieDao().update(movie);
        if (isUpdate) return Response.status(204).build();
        return Response.status(404)
                .entity("Le film exist pas")
                .build();
    }

}