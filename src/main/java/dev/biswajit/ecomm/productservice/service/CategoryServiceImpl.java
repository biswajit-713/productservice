package dev.biswajit.ecomm.productservice.service;

import dev.biswajit.ecomm.productservice.dto.ProductDto;
import dev.biswajit.ecomm.productservice.model.Category;
import dev.biswajit.ecomm.productservice.model.Product;
import dev.biswajit.ecomm.productservice.repository.CategoryRepository;
import dev.biswajit.ecomm.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Mono<List<Category>> allCategories() {
        return Mono.just(categoryRepository.findAll());
    }

    @Override
    public Mono<List<ProductDto>> findProductsByCategory(String title) {
        List<Product> productsByCategory = productRepository.findProductsByCategory(title);

        List<ProductDto> productDtoList = productsByCategory
                .stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .title(product.getName())
                        .category(product.getCategory().getTitle())
                        .price(product.getPrice().getValue().toString())
                        .imageUrl(product.getImage())
                        .build())
                .toList();
        return Mono.just(productDtoList);
    }
}
