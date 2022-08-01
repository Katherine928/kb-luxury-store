package com.katherine.katherine.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bag {
    private String bag_id;
    private String bag_name;
    private String color;
    private BigDecimal price;
    private String material;
    private float bag_length;
    private float bag_height;
    private float bag_width;
    private String description;
    private String image_url;
    private int online;
    private String categories;
    private String iconic;

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getIconic() {
        return iconic;
    }

    public void setIconic(String iconic) {
        this.iconic = iconic;
    }



    public String getBag_id() {
        return bag_id;
    }

    public void setBag_id(String bag_id) {
        this.bag_id = bag_id;
    }

    public String getBag_name() {
        return bag_name;
    }

    public void setBag_name(String bag_name) {
        this.bag_name = bag_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getBag_length() {
        return bag_length;
    }

    public void setBag_length(float bag_length) {
        this.bag_length = bag_length;
    }

    public float getBag_height() {
        return bag_height;
    }

    public void setBag_height(float bag_height) {
        this.bag_height = bag_height;
    }

    public float getBag_width() {
        return bag_width;
    }

    public void setBag_width(float bag_width) {
        this.bag_width = bag_width;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
