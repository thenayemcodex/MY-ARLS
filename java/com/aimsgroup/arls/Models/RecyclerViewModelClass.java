package com.aimsgroup.arls.Models;

public class RecyclerViewModelClass {
    String fullName;
    String firstWordName;
    String shortcutName;
    int image;

    public String getFullName() {
        return fullName;
    }

    public String getFirstWordName() {
        return firstWordName;
    }

    public String getShortcutName() {
        return shortcutName;
    }

    public int getImage() {
        return image;
    }




    public RecyclerViewModelClass(String fullName, String firstWordName, String shortcutName, int image) {
        this.fullName = fullName;
        this.firstWordName = firstWordName;
        this.shortcutName = shortcutName;
        this.image = image;
    }




}
