package com.shopping.order.model;



import com.shopping.order.dto.ProductDto;

import java.util.List;

public class CheckoutRequestModel {
	
	private List<ProductDto> products;

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

	
}
