package com.example.burgerordersystem.Repository;

import com.example.burgerordersystem.Model.Menu;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
@RequiredArgsConstructor
@Repository
public class MenuRepo {
    private List<Menu> menus = new ArrayList<>();

    public List<Menu> getMenus(){
        return menus;
    }

    public Menu getMenuById(int id){
         return menus.stream()
                 .filter(menu -> menu.getId()== id).findFirst().get()
                 .orElseThrow(NoSuchElementException::new);

    }

    public Menu addMenu(Menu menu) {
        menus.add(menu);
        return menu;
    }
}