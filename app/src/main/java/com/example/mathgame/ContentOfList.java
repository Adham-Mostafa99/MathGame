package com.example.mathgame;

public class ContentOfList {
    private String level;
    private int image, color;

    ContentOfList(String level, int image, int color) {
        this.level = level;
        this.image = image;
        this.color = color;
    }

    public String getLevel() {
        return level;
    }

    public int getImage() {
        return image;
    }

    public int getColor() {
        return color;
    }
}
