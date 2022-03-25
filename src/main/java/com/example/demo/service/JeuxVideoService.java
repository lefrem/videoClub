package com.example.demo.service;

import com.example.demo.controller.model.JeuxVideoResponse;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.JeuxVideoDao;

import java.util.List;
import java.util.stream.Collectors;

public class JeuxVideoService {

    public List<JeuxVideoResponse> fetchAll() {
        JeuxVideoDao jeuxVideoDao = DaoFactory.getJeuxVideoDao();

        return jeuxVideoDao
                .findAll()
                .stream()
                .map(m -> m.toDto())
                .collect(Collectors.toList());
    }
}
