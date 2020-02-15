package com.example.javademospringmvc.Model;

public class Platform {
    private String name;
    private String images;
    private int oldprice;
    private int newprice;
    private int sale;

    public Platform(String name, String images, int oldprice, int newprice, int sale) {
        this.name = name;
        this.images = images;
        this.oldprice = oldprice;
        this.newprice = newprice;
        this.sale = sale;
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

    public int getOldprice() {
        return oldprice;
    }

    public void setOldprice(int oldprice) {
        this.oldprice = oldprice;
    }

    public int getNewprice() {
        return newprice;
    }

    public void setNewprice(int newprice) {
        this.newprice = newprice;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
}
