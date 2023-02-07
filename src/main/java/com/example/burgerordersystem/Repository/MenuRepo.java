package com.example.burgerordersystem.Repository;

import com.example.burgerordersystem.Model.Menu;
import lombok.Data;

import java.util.List;

@Data
public class MenuRepo {
    private List<Menu> menus;

    public List<Menu> getAllMenus() {
        return menus;
    }
}
