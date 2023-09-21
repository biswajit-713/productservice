package dev.biswajit.ecomm.productservice.controller;

import dev.biswajit.ecomm.productservice.dto.CategoryDto;
import dev.biswajit.ecomm.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(@Autowired CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/")
    Flux<CategoryDto> getAllCategories() {

        return categoryService.allCategories()
                .flatMapMany(Flux::fromIterable)
                .flatMap(it -> Mono.just(CategoryDto.builder()
                        .categoryId(it.getId())
                        .title(it.getTitle())
                        .build()));
    }
}
