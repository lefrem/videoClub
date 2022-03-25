package com.example.demo.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CreateJeuxVideo {

    private String title;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    private int quantity;

    public CreateJeuxVideo() {

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

    @Override
    public String toString() {
        return "CreateJeuxVideo{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", quantity=" + quantity +
                '}';
    }
}
