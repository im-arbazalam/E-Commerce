package com.example.Ecommerce.dto.ResponseDto;

import com.example.Ecommerce.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder

public class ProductResponseDto {
    String productName;

    String sellerName;

    int quantity;

    ProductStatus productStatus;
}
