package com.example.demo.service;

import com.example.demo.controller.model.MovieResponse;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.MovieDao;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    public List<MovieResponse> fetchAll() {
        MovieDao movieDao = DaoFactory.getMovieDao();

        return movieDao
                .findAll()
                .stream()
                .map(m -> m.toDto())
                .collect(Collectors.toList());
    }
}
