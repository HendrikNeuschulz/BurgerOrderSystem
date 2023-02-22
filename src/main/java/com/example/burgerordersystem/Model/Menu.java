package com.example.burgerordersystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Menu {

    private int id;
    private String name;
    private int price;

    private MainDish mainDish;
    private SideDish sideDish;
    private Beverage beverage;



}
