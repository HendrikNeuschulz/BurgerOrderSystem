package com.example.burgerordersystem.Model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum SideDish {
    FRENCH_FRIES("French fries"),
    FARM_WEDGES("Farm wedges");
    String nameSideDish;
}
