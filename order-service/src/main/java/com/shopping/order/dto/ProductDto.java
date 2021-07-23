package com.shopping.order.dto;

import java.io.Serializable;

//Product data transfer object for passing product details between different layers

public class ProductDto implements Serializable{

	private static final long serialVersionUID = -4091816327300017988L;

	private String productId;
	
	private String name;

    private Double price;

    private String pictureUrl;
    
    private String quantity;

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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
    
    
    

}
