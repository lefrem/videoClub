package com.example.demo.service;

import com.example.demo.controller.model.AlbumResponse;
import com.example.demo.controller.model.MovieResponse;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.AlbumDao;
import com.example.demo.dao.base.MovieDao;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumService {

    public List<AlbumResponse> fetchAll() {
        AlbumDao albumDao = DaoFactory.getAlbumDao();

        return albumDao
                .findAll()
                .stream()
                .map(m -> m.toDto())
                .collect(Collectors.toList());
    }
}
