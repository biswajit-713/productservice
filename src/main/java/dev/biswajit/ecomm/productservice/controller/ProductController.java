package dev.biswajit.ecomm.productservice.controller;

import dev.biswajit.ecomm.productservice.dto.ProductDto;
import dev.biswajit.ecomm.productservice.model.Product;
import dev.biswajit.ecomm.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public Mono<List<ProductDto>> getAll() {
        return productService.allProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getBy(@PathVariable("id") Long productId) {
        return productService.productBy(productId);
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<ProductDto> add(@RequestBody ProductDto newProduct) {
        return productService.add(newProduct);
    }

    @PutMapping("/{id}")
    public Mono<ProductDto> updateBy(@PathVariable("id") Long id, @RequestBody ProductDto updateProductDto) {
        return productService.updateBy(id, updateProductDto);
    }

    @DeleteMapping("/{id}")
    public Mono<ProductDto> deleteBy(@PathVariable Long id) {
        return productService.deleteBy(id);
    }

}
