package com.example.android_projekt_252876;

public class PrzepisElementy {

    int Image;
    String Name;

    public PrzepisElementy(int image, String name) {
        Image = image;
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
