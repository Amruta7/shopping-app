package com.shopping.product.service;

import com.shopping.product.dto.ProductDto;
import com.shopping.product.entity.Product;
import com.shopping.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	ProductRepository productRepository;
    
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository)
	{
		this.productRepository=productRepository;
	}


	@Override
	public void addProduct(ProductDto productDto) {
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Product product=modelMapper.map(productDto, Product.class);
		productRepository.save(product);
		
	}


	@Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

   

	@Override
    public Product getProduct(long id) {
        return productRepository.findById(id);
    }
    
    
}