package com.walk.model;

public class OnBoardItem {
    int id;
    int image;
    String desc1;
    String desc2;
    String button;

    public OnBoardItem(int id, int image, String desc1, String desc2, String button) {
        this.id = id;
        this.image = image;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.button = button;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
