package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer")
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true)
    String emailId;

    Integer age;

    @Column(unique = true)
    String mobNo;

    String address;
}
