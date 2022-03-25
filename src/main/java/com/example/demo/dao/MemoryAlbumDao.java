package com.example.demo.dao;

import com.example.demo.dao.base.AlbumDao;
import com.example.demo.dao.base.MovieDao;
import com.example.demo.dao.entity.Album;
import com.example.demo.dao.entity.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryAlbumDao implements AlbumDao {

    private static Long idSequence = 0L;
    private static List<Album> albums = new ArrayList<>();

    @Override
    public Long save(Album album) {
        album.setId(++idSequence);
        albums.add(album);
        return album.getId();
    }

    @Override
    public List<Album> findAll() {
        return Collections.unmodifiableList(albums);
    }

    @Override
    public Optional<Album> findById(Long id) {
        return this.albums.stream()
                .filter(album -> album.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Album albumToUpdate) {
        boolean isUpdate = false;
        List<Album> tempList = new ArrayList<>();
        for (Album a : albums) {
            if (a.getId() == albumToUpdate.getId()) {
                tempList.add(albumToUpdate);
                isUpdate=true;
            } else {
                tempList.add(a);
            }
        }
        this.albums = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.albums = this.albums.stream()
                .filter(album -> album.getId() != id)
                .collect(Collectors.toList());

    }
}
