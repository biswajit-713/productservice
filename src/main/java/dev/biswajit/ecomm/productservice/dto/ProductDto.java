package dev.biswajit.ecomm.productservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {
    private final Long id;
    private final String title;
    private final String price;
    private final String category;
    private final String description;
    @JsonProperty("image")
    private final String imageUrl;
}
