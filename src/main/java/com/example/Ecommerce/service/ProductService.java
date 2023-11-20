package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.RequestDto.ProductRequestDto;
import com.example.Ecommerce.dto.ResponseDto.ProductResponseDto;
import com.example.Ecommerce.exception.InvalidSellerException;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.Seller;
import com.example.Ecommerce.repository.ProductRepository;
import com.example.Ecommerce.repository.SellerRepository;
import com.example.Ecommerce.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws InvalidSellerException {

        Seller seller;
        try{
            seller =  sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e){
            throw new InvalidSellerException("Seller doesn't exist");
        }

        Product product = ProductTransformer.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        // add product to current products of seller
        seller.getProducts().add(product);
        sellerRepository.save(seller);  // saves both seller and product

        // prepare Response Dto
        return ProductTransformer.ProductToProductResponseDto(product);
    }
}
