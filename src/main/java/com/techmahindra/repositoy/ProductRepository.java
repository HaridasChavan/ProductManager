package com.techmahindra.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmahindra.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
