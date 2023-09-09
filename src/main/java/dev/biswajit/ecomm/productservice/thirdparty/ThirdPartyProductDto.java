package dev.biswajit.ecomm.productservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String imageUrl;
}
