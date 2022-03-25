package com.example.demo.dao.entity;

import com.example.demo.controller.model.JeuxVideoResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class JeuxVideo {

    private Long id;
    private String title;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    private int quantity;

    public JeuxVideo() {
    }

    public JeuxVideo(String title, LocalDate releaseDate, int quantity) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
    }

    public JeuxVideoResponse toDto(){
        JeuxVideoResponse jv = new JeuxVideoResponse();
        jv.setId(this.id);
        jv.setTitle(this.title);
        jv.setReleaseDate(this.releaseDate);
        jv.setQuantity(this.quantity);
        return jv;
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
