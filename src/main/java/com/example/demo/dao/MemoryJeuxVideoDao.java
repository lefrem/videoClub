package com.example.demo.dao;

import com.example.demo.dao.base.JeuxVideoDao;
import com.example.demo.dao.entity.Album;
import com.example.demo.dao.entity.JeuxVideo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryJeuxVideoDao implements JeuxVideoDao {

    private static Long idSequence = 0L;
    private static List<JeuxVideo> jeuxVideos = new ArrayList<>();

    @Override
    public Long save(JeuxVideo jeuxVideo) {
        jeuxVideo.setId(++idSequence);
        jeuxVideos.add(jeuxVideo);
        return jeuxVideo.getId();
    }

    @Override
    public List<JeuxVideo> findAll() {
        return Collections.unmodifiableList(jeuxVideos);
    }

    @Override
    public Optional<JeuxVideo> findById(Long id) {
        return this.jeuxVideos.stream()
                .filter(jeuxVideo -> jeuxVideo.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(JeuxVideo jeuxVideoToUpdate) {
        boolean isUpdate = false;
        List<JeuxVideo> tempList = new ArrayList<>();
        for (JeuxVideo jv : jeuxVideos) {
            if (jv.getId() == jeuxVideoToUpdate.getId()) {
                tempList.add(jeuxVideoToUpdate);
                isUpdate=true;
            } else {
                tempList.add(jv);
            }
        }
        this.jeuxVideos = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.jeuxVideos = this.jeuxVideos.stream()
                .filter(jeuxVideo -> jeuxVideo.getId() != id)
                .collect(Collectors.toList());
    }
}
