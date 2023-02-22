package com.example.burgerordersystem.Controller;

import com.example.burgerordersystem.Model.Menu;
import com.example.burgerordersystem.Service.BurgerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api")
public class BurgerController {

    BurgerService burgerService;

    @GetMapping("menus")
    public List<Menu> getAllMenus() {
         return null;
    }

    @GetMapping("menus/{id}")
    public List<Menu> getMenu( @PathVariable String id){

        return null; //burgerService.getMenuById();
    }


}
