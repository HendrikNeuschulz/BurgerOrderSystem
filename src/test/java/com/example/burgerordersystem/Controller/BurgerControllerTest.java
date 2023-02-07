package com.example.burgerordersystem.Controller;
import com.example.burgerordersystem.Model.Menu;

import com.example.burgerordersystem.Repository.MenuRepo;
import com.example.burgerordersystem.Service.BurgerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


class BurgerServiceTest {

    Menu menu = mock(Menu.class);
//    BurgerService burgerService = mock(BurgerService.class);
    MenuRepo menuRepo = mock(MenuRepo.class);
    BurgerService burgerService = new BurgerService(menuRepo);


    @Test
    void getAllMenus_shouldReturnAllOrders() {
                    //Given

        when(menuRepo.getAllMenus().thenReturn(new ArrayList<Menu>() {}));

        //When

        //Then
        Assertions.assertEquals(new ArrayList<Menu>(), menuRepo.getAllMenus());


    }
}