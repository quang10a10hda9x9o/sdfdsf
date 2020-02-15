package com.example.javademospringmvc.Model;

public class Menuitem {
    private String name;
    private String images;

    public Menuitem(String name, String images) {
        this.name = name;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
