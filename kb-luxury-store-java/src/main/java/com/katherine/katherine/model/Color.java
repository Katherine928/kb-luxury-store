package com.katherine.katherine.model;

public class Color {

    private String colorName;
    private String colorImage;
    private String status;

    public String getColorName() {
        return colorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorImage() {
        return colorImage;
    }

    public void setColorImage(String colorImage) {
        this.colorImage = colorImage;
    }
}
