package com.example.demo.dao.entity;

import com.example.demo.controller.model.AlbumResponse;
import com.example.demo.controller.model.MovieResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Album {

    private Long id;
    private String title;
    private double duration;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    private int quantity;

    public Album() {
    }

    public Album(String title, double duration, LocalDate releaseDate, int quantity) {
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
    }

    public AlbumResponse toDto(){
        AlbumResponse a = new AlbumResponse();
        a.setId(this.id);
        a.setTitle(this.title);
        a.setDuration(this.duration);
        a.setReleaseDate(this.releaseDate);
        a.setQuantity(this.quantity);
        return a;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
