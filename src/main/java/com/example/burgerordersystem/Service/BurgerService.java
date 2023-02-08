package com.example.burgerordersystem.Service;

import com.example.burgerordersystem.Model.Menu;
import com.example.burgerordersystem.Repository.MenuRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BurgerService {
    private MenuRepo menuRepo = new MenuRepo();

    BurgerService() {
    }

    public Optional<Menu> getMenuById(int id) {
        return menuRepo.getMenuById(id);
    }
    public List<Menu> getMenus() {
        return menuRepo.getMenus();
    }

    public Optional<List<Menu>> addMenu(Menu menuMock) {
        return menuRepo.addMenu(menuMock);
    }
}
