package dev.biswajit.ecomm.productservice.service;

import dev.biswajit.ecomm.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfManagedProductService {
    private final ProductRepository productRepository;

    @Autowired
    public SelfManagedProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
