package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.RequestDto.ProductRequestDto;
import com.example.Ecommerce.dto.ResponseDto.ProductResponseDto;
import com.example.Ecommerce.exception.InvalidSellerException;
import com.example.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto) throws InvalidSellerException {

        return productService.addProduct(productRequestDto);
    }
}
