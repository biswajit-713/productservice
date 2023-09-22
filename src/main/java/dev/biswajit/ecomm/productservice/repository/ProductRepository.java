package dev.biswajit.ecomm.productservice.repository;

import dev.biswajit.ecomm.productservice.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository(value = "PRODUCT_REPOSITORY")
public interface ProductRepository extends JpaRepository<Product, Long> {

//    Mono<Product> findProductById(Long id);

    @Query(value = "SELECT P.* FROM PRODUCTS P INNER JOIN CATEGORIES C ON P.CATEGORY_ID=C.ID AND C.TITLE=:title",
            nativeQuery = true)
    List<Product> findProductsByCategory(String title);

}
