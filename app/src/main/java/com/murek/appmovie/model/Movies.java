package com.murek.appmovie.model;

public class Movies {

    private String title, cover;
    private float estrellas;

    public Movies(String title, String cover, float estrellas){
        this.title = title;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }
}
