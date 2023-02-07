package com.example.burgerordersystem.Controller;

import com.example.burgerordersystem.Model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api")
public class BurgerController {

    @GetMapping
    public List<Menu> getAllMenus() {

    }
}
