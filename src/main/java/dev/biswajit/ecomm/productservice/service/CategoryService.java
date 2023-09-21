package dev.biswajit.ecomm.productservice.service;

import dev.biswajit.ecomm.productservice.model.Category;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryService {
    Mono<List<Category>> allCategories();
}
