package com.ify.services.orderservice.common;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderdto {
    private int id;
    private String name;
    private int quantity;
    private double price;
}
