package com.example.demo;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.base.AlbumDao;
import com.example.demo.dao.base.JeuxVideoDao;
import com.example.demo.dao.base.MovieDao;
import com.example.demo.dao.base.UserDao;
import com.example.demo.dao.entity.Album;
import com.example.demo.dao.entity.JeuxVideo;
import com.example.demo.dao.entity.Movie;
import com.example.demo.dao.entity.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;

@WebListener
public class AppListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.save(new Movie("La ligne verte", 188, LocalDate.ofYearDay(1999, 1), 5));
        movieDao.save(new Movie("Le parrain", 175, LocalDate.ofYearDay(1972, 1), 5));
        movieDao.save(new Movie("H2G2", 109, LocalDate.ofYearDay(2005, 1), 5));
        movieDao.save(new Movie("Que justice soit faite", 104, LocalDate.ofYearDay(2009, 1), 5));
        movieDao.save(new Movie("Les affranchis", 146, LocalDate.ofYearDay(1990, 1), 5));
        movieDao.save(new Movie("Metropolis", 153, LocalDate.ofYearDay(1927, 1), 5));
        movieDao.save(new Movie("Blade Runner 2049", 163, LocalDate.ofYearDay(2017, 1), 5));
        movieDao.save(new Movie("Princesse Mononoké", 133, LocalDate.ofYearDay(1997, 1), 5));
        movieDao.save(new Movie("Transformers", 224, LocalDate.ofYearDay(2007, 1), 5));

        UserDao userDao = DaoFactory.getUserDao();
        userDao.save(new User(20,"aa","aa","aa","aa","aa"));
        userDao.save(new User(21,"bb","bb","bb","bb","bb"));
        userDao.save(new User(22,"cc","cc","cc","cc","cc"));

        AlbumDao albumDao = DaoFactory.getAlbumDao();
        albumDao.save(new Album("thriller de michael jackson", 6, LocalDate.ofYearDay(1983, 1), 5));
        albumDao.save(new Album("No.6 Collaboration Project", 50, LocalDate.ofYearDay(2016, 1), 5));
        albumDao.save(new Album("Loose Change", 32, LocalDate.ofYearDay(2011, 1), 5));

        JeuxVideoDao jeuxVideoDao = DaoFactory.getJeuxVideoDao();
        jeuxVideoDao.save(new JeuxVideo("God of War",LocalDate.ofYearDay(2018,1),5));
        jeuxVideoDao.save(new JeuxVideo("Tom Clancy's The Division",LocalDate.ofYearDay(2016,1),5));
        jeuxVideoDao.save(new JeuxVideo("Kirby et le monde oublié",LocalDate.ofYearDay(2022,1),5));
    }
}
