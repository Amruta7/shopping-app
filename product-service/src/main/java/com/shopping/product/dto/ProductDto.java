package com.shopping.product.dto;

import java.io.Serializable;

//Product data transfer object for passing product details between different layers

public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1265641347095347692L;

    private String productId;

    private String name;

    private Double price;

    private String pictureUrl;

    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


}
