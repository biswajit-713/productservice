package dev.biswajit.ecomm.productservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableJpaRepositories(basePackages = "com.example.repository")
public class ProductRepositoryConfiguration {

//    @Autowired
//    private JpaRepository<?, ?> jpaRepository; // Autowire Spring Data JPA repository


    @Bean
    @Conditional(CustomRepositoryCondition.class)
    public ProductRepository fakeStoreRepository() {
        return new FakeStoreProductRepository();
    }
}
