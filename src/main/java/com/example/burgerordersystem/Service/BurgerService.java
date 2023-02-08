package com.example.burgerordersystem.Service;

import com.example.burgerordersystem.Model.Menu;
import com.example.burgerordersystem.Repository.MenuRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurgerService {
    private MenuRepo menuRepo = new MenuRepo();

    BurgerService() {
    }

    public Menu getMenuById(int id) {
        return menuRepo.getMenuById(id);
    }
    public List<Menu> getMenus() {
        return menuRepo.getMenus();
    }

    public Menu addMenu(Menu menu) {
        return  menuRepo.addMenu(menu);
    }
}
