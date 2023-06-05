package com.compasso.uol.repositories;

import com.compasso.uol.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Wanderson Silva
 * @version 1.0.0
 * @since 2021-05-26
 *
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}