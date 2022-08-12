package com.techmahindra.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techmahindra.model.Product;
import com.techmahindra.repositoy.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> listAll() {
		return repo.findAll();
	}

	@Override
	public Product save(Product product) {
		return repo.save(product);
	}

	@Override
	public Product get(Long id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		throw new RuntimeException("Product is not found for the id" + id);
	}

	@Override
	public Object delete(Long id) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		logger.info("Product Deleted Sucessfully");
		return new ResponseEntity<>("Product Deleted suceesfully", HttpStatus.OK);
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		return repo.findById(id).get();
	}

}
