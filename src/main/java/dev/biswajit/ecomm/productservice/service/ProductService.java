package dev.biswajit.ecomm.productservice.service;

import dev.biswajit.ecomm.productservice.dto.ProductDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {
    Mono<ProductDto> productBy(Long id);

    Mono<List<ProductDto>> allProducts();

    Mono<ProductDto> add(ProductDto newProduct);

    Mono<ProductDto> deleteBy(Long id);

    Mono<ProductDto> updateBy(Long id, ProductDto updateProductDto);
}
