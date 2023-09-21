package dev.biswajit.ecomm.productservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
public class CategoryDto {
    @JsonProperty(value = "id")
    private UUID categoryId;
    @JsonProperty(value = "title")
    private String title;
}
