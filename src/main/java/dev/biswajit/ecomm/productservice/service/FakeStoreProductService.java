package dev.biswajit.ecomm.productservice.service;

import dev.biswajit.ecomm.productservice.dto.FakeStoreProductDto;
import dev.biswajit.ecomm.productservice.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("FAKE_STORE_SERVICE")
@ConditionalOnProperty(name= "service.type", havingValue = "FAKE_STORE_SERVICE")
public class FakeStoreProductService implements ProductService {

    private final WebClient webclient ;

    @Value("${fakestore.url}")
    private String fakeStoreUrl = "https://fakestoreapi.com";

    public FakeStoreProductService(@Autowired WebClient.Builder builder) {
        this.webclient = builder.baseUrl(fakeStoreUrl).build();
    }

    @Override
    public Mono<ProductDto> productBy(Long id) {
        Mono<FakeStoreProductDto> fakeStoreProduct = webclient
                .get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(FakeStoreProductDto.class)
                .log();

        return fakeStoreProduct.map(it ->
                new ProductDto(it.getId(), it.getTitle(), it.getPrice(), it.getCategory(), it.getDescription(),
                        it.getImageUrl())).log();
    }

    @Override
    public Mono<List<ProductDto>> allProducts() {
        Mono<List<FakeStoreProductDto>> fakeStoreProducts = webclient
                .get()
                .uri("/products")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<FakeStoreProductDto>>() {
                })
                .log();

        return fakeStoreProducts.flatMap(list -> {
            List<ProductDto> products = list.stream().map(it -> new ProductDto(it.getId(), it.getTitle(), it.getPrice(), it.getCategory(),
                    it.getDescription(), it.getImageUrl()
            )).toList();
            return Mono.just(products);
        });
    }

    @Override
    public Mono<ProductDto> add(ProductDto newProduct) {
        Mono<FakeStoreProductDto> productFromFakeStore = webclient
                .post()
                .uri("/products")
                .body(BodyInserters.fromValue(newProduct))
                .retrieve()
                .bodyToMono(FakeStoreProductDto.class)
                .log();

        return productFromFakeStore.map(it ->
                new ProductDto(it.getId(), it.getTitle(), it.getPrice(), it.getCategory(), it.getDescription(),
                        it.getImageUrl())).log();
    }

    @Override
    public Mono<ProductDto> deleteBy(Long id) {
        Mono<FakeStoreProductDto> deletedProduct = webclient
                .delete()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(FakeStoreProductDto.class)
                .log();

        return deletedProduct.map(it ->
                new ProductDto(it.getId(), it.getTitle(), it.getPrice(), it.getCategory(), it.getDescription(),
                        it.getImageUrl())).log();
    }

    @Override
    public Mono<ProductDto> updateBy(Long id, ProductDto updateProductDto) {
        Mono<FakeStoreProductDto> fakeStoreProductDto = webclient
                .put()
                .uri("/products/{id}", id)
                .body(BodyInserters.fromValue(updateProductDto))
                .retrieve()
                .bodyToMono(FakeStoreProductDto.class)
                .log();

        return fakeStoreProductDto.map(it ->
                new ProductDto(it.getId(), it.getTitle(), it.getPrice(), it.getCategory(),
                        it.getDescription(), it.getImageUrl())).log();
    }
}
