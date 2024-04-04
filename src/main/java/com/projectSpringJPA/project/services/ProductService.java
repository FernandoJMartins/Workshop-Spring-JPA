package com.projectSpringJPA.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectSpringJPA.project.entities.Product;
import com.projectSpringJPA.project.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pr;
	
	public List<Product> findAll() {
		return pr.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = pr.findById(id);
		return obj.get();
	}
}
