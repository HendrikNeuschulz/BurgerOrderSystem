package com.example.burgerordersystem.Model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum MainDish {
// implements Serializable {
    HAMBURGER("Hamburger"), CHEESEBURGER("Cheeseburger"), VEGGIEBURGER("Veggieburger");

    String name;


}
