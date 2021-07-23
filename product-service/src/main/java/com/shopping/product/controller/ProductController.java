package com.shopping.product.controller;

import com.shopping.product.dto.ProductDto;
import com.shopping.product.entity.Product;
import com.shopping.product.model.AddProductRequestModel;
import com.shopping.product.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/products")
public class ProductController {

	ProductService productService;
	
	@Autowired
    public ProductController(ProductService productService) {
		this.productService = productService;
	}


	@GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
	
	@PostMapping("/add")
	public void addProduct(@RequestBody AddProductRequestModel addProductRequestModel)
	{
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDto product=modelMapper.map(addProductRequestModel, ProductDto.class);
		productService.addProduct(product);
	}
}