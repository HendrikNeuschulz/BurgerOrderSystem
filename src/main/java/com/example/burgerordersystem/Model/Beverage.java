package com.example.burgerordersystem.Model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum Beverage {
    SOFT_DRINK("Soft_Drink"), HOT_BEVERAGE("Hot_Beverage");

    String nameDrink;
}
