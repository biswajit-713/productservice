package dev.biswajit.ecomm.productservice.repository;

import dev.biswajit.ecomm.productservice.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository(value = "PRODUCT_REPOSITORY")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
