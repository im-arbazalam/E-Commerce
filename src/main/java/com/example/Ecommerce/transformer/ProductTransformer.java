package com.example.Ecommerce.transformer;

import com.example.Ecommerce.Enum.ProductStatus;
import com.example.Ecommerce.dto.RequestDto.ProductRequestDto;
import com.example.Ecommerce.dto.ResponseDto.ProductResponseDto;
import com.example.Ecommerce.model.Product;

public class ProductTransformer {

    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .name(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .productCategory(productRequestDto.getProductCategory())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getName())
                .sellerName(product.getSeller().getName())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();
    }

}
