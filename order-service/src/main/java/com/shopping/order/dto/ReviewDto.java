package com.shopping.order.dto;

import java.io.Serializable;

//Review data transfer object for passing reviews information between different layers

public class ReviewDto implements Serializable{
	
	private static final long serialVersionUID = 6914669837827501532L;
	
	private String userId;
	private ProductDto product;
	private String userName;
	private String comment;
	private int ratings;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
}
