package com.example.burgerordersystem.Controller;

import com.example.burgerordersystem.Model.Beverage;
import com.example.burgerordersystem.Model.MainDish;
import com.example.burgerordersystem.Model.Menu;
import com.example.burgerordersystem.Model.SideDish;
import com.example.burgerordersystem.Repository.MenuRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Nested
@DisplayName("BurgerController Integration Tests")
class BurgerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MenuRepo menuRepo;

    Menu validMenu = new Menu(1, "Hamburger Menu", 1000, MainDish.HAMBURGER, SideDish.FRENCH_FRIES, Beverage.SOFT_DRINK);
    String validMenuJsonString = """
            {
                "id": 1,
                "name": "Hamburger Menu",
                "price": 1000,
                "mainDish": "Hamburger",
                "sideDish": "French fries",
                "beverage": "Soft_Drink"
            }
            """;
    Menu invalidMenu = new Menu(1, "Hamburger Menu", 1000, MainDish.HAMBURGER, null, Beverage.SOFT_DRINK);
    @BeforeEach
    void setUpTestingEnvironment() {
        System.out.println("Nothing necessary to setup yet");
    }

    @Nested
    @DisplayName("getAllMenus tests")
    class getAllMenus {
        @Test
        void getAllMenus_shouldReturnAnEmptyArrayIfTheRepoIsEmpty() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("[]"));
        }


        @Test
        void getAllMenus_shouldReturnAnArrayWithAMenuIfTheEmptyRepositoryWasAddedAMenu () throws Exception {
        menuRepo.addMenu(validMenu);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                .andExpect(status().isOk())
                .andExpect(content().json("[" + validMenuJsonString + "]"));
        }
    }


    @Nested
    @DisplayName("getMenuById")
    class getMenuById {
        @Test
        void getMenuById_returnsAMenuIfTheRepositoryContainsAMenuWithTheGivenId() throws Exception {
            menuRepo.addMenu(validMenu);
            mockMvc.perform(MockMvcRequestBuilders.get("/api/menus/1"))
                    .andExpect()
            ;
        }
    }


}