package com.shopping.product.service;


import com.shopping.product.dto.ProductDto;
import com.shopping.product.entity.Product;

public interface ProductService {


	Iterable<Product> getAllProducts();

	Product getProduct(long id);

	void addProduct(ProductDto product);

}
