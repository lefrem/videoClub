package com.example.demo.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateMovie implements Serializable {

    private String title;
    private  double duration;

    @JsonFormat(pattern = "dd-MM-yyyy")  //précisse le rendu du json
    private LocalDate releaseDate;
    private int quantity;

    public CreateMovie() {

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

    @Override
    public String toString() {
        return "CreateMovie{" +
                "title='"           + title         + '\'' +
                ", duration="       + duration      +
                ", releaseDate="    + releaseDate   +
                ", quantity="       + quantity      +
                '}';
    }
}
