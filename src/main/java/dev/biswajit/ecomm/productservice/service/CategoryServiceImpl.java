package dev.biswajit.ecomm.productservice.service;

import dev.biswajit.ecomm.productservice.model.Category;
import dev.biswajit.ecomm.productservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Mono<List<Category>> allCategories() {
        return Mono.just(categoryRepository.findAll());
    }
}
