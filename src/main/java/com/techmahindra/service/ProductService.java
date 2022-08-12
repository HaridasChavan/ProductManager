package com.techmahindra.service;

import java.util.List;

import com.techmahindra.model.Product;

public interface ProductService {

	public List<Product> listAll();

	public Product save(Product product);

	public Product get(Long id);

	public Object delete(Long id);

	public Product updateProduct(Product product, Long id);

}
