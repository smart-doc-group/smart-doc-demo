package com.smartdoc.example.model;

/**
 * @author yu 2021/7/24.
 */
public class Product {

    /**
     * Product id
     */
    private Long id;

    /**
     * Product name
     */
    private String name;

    /**
     * Product price
     */
    private Double price;

    /**
     * Product picture url
     */
    private String pictureUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
