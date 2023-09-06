package dev.biswajit.ecomm.productservice.productcontroller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductControllerIntegrationTest {
    @Test
    void shouldReturnProductWhenSearchedById() {

    }

    @Test
    void shouldThrowExceptionWhenProductIsNotFound() {

    }

    @Test
    void shouldReturnAllProducts() {

    }

    @Test
    void shouldCreateProduct() {

    }

    @Test
    void shouldUpdateTheProductAttributes() {

    }

}
