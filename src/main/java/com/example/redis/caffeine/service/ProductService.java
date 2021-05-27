package com.example.redis.caffeine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.redis.caffeine.entity.Product;
import com.example.redis.caffeine.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Cacheable(key = "#id", value = "product")
	public Product findProductById(Integer id){
		System.out.println("Fetching data from DB");
		return productRepository.findById(id).get();
	}
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	@CachePut(value = "product")
	public Product saveProduct(Product product){
		productRepository.save(product);
		return product;
	}
	@CacheEvict(key = "#id", value = "product")
	public String deleteProductById(Integer id){
		System.out.println("Removing data from cache");
		productRepository.deleteById(id);
		return "Product Deleted!!!";
	}

}
