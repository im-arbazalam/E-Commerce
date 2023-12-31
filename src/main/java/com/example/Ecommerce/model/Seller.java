package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="seller")
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder //we can create an object of Seller class jis class ko entity m convert karna h uske upr @Builder likho
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true)
    String emailId;

    Integer age;

    String mobNo;


    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();
}
