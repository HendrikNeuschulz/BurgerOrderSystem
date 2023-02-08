package com.example.burgerordersystem.Repository;

import com.example.burgerordersystem.Model.Menu;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class MenuRepo {
    private List<Menu> menus = new ArrayList<>();

    public Optional<Menu> getMenuById(int id) {
        return Optional.ofNullable(menus.stream().filter(menu -> menu.getId() == id).findFirst()).orElse(null);
    }

    public Optional<List<Menu>> addMenu(Menu menuMock) {
        return null;
    }
}
