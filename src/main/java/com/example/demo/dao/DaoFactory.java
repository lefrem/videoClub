package com.example.demo.dao;

import com.example.demo.dao.base.AlbumDao;
import com.example.demo.dao.base.JeuxVideoDao;
import com.example.demo.dao.base.MovieDao;
import com.example.demo.dao.base.UserDao;

public final class DaoFactory {

    private DaoFactory() {

    }

    public static MovieDao getMovieDao() {
        return new MemoryMovieDao();
    }

    public static UserDao getUserDao() {
        return new MemoryUserDao();
    }

    public static AlbumDao getAlbumDao() {
        return new MemoryAlbumDao();
    }

    public static JeuxVideoDao getJeuxVideoDao() {
        return new MemoryJeuxVideoDao();
    }
}
