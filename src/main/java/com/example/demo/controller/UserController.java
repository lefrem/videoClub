package com.example.demo.controller;

import com.example.demo.controller.model.CreateMovie;
import com.example.demo.controller.model.CreateUser;
import com.example.demo.controller.model.MovieResponse;
import com.example.demo.controller.model.UserResponse;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.MovieDao;
import com.example.demo.dao.base.UserDao;
import com.example.demo.dao.entity.Movie;
import com.example.demo.dao.entity.User;
import com.example.demo.service.MovieService;
import com.example.demo.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilderException;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserController {
    private static final List<User> users = new ArrayList<>();

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<UserResponse> userResponses = userService.fetchAll();
        return Response.ok(userResponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(CreateUser createUser) throws UriBuilderException {

        User user = new User(createUser.getBirth(), createUser.getFirstName(), createUser.getLastName(), createUser.getAddress(), createUser.getPhoneNumber(), createUser.getMail());
        UserDao userDao = DaoFactory.getUserDao();
        userDao.save(user);
        return Response.status(201).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        DaoFactory.getUserDao().delete(id);
        return Response.ok(users).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(User user) {
        boolean isUpdate = DaoFactory.getUserDao().update(user);
        if (isUpdate) return Response.status(204).build();
        return Response.status(404)
                .entity("Le user exist pas")
                .build();
    }

}