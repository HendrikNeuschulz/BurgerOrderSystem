package com.example.burgerordersystem.Service;
import com.example.burgerordersystem.Model.Menu;

import com.example.burgerordersystem.Repository.MenuRepo;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


@DisplayName("BurgerService Test")
class BurgerServiceTest {
    Menu menuMock;
    MenuRepo menuRepoMock;
    BurgerService burgerService;
    BurgerService burgerServiceMock;
    @BeforeEach
    void setUpTestingEnvironment() {
        //Given
        menuMock = mock(Menu.class);
//      BurgerService burgerService = mock(BurgerService.class);
        menuRepoMock = mock(MenuRepo.class);
        burgerService = new BurgerService(menuRepoMock);
        burgerServiceMock = mock(BurgerService.class);

    }

    @Nested
    @DisplayName("Test for getAllMenus()")
    class getAllMenus {
        @Test
        @DisplayName("returns an empty list when the repository is empty")
        void getAllMenus_shouldReturnAllMenusOfAnEmptyRepository() {
            //When
            when(menuRepoMock.getMenus()).thenReturn(new ArrayList<Menu>() {});

            //Then
            Assertions.assertEquals(new ArrayList<Menu>(), menuRepoMock.getMenus());
        }

         @Test
         @DisplayName("returns a list of menus when the repository is not empty")
         void getAllMenus_shouldReturnAllMenusOfANonEmptyRepository() {
             //When
             when(menuRepoMock.getMenus()).thenReturn(new ArrayList<Menu>() {
                 {
                     add(menuMock);
                 }
             });

             //Then
             Assertions.assertEquals(
                   new ArrayList<Menu>() {{add(menuMock);}},
                   menuRepoMock.getMenus()
             );
         }
         @Test
         @DisplayName("throws an exception when the repository is null")
         void getAllMenus_shouldThrowAnExceptionWhenTheRepositoryIsNull() {
            //Given
             menuRepoMock.setMenus(null);
            //When
             when(menuRepoMock.getMenus()).thenReturn(null);

             //Then
             Assertions.assertThrows(NullPointerException.class, () -> menuRepoMock.getMenus());
         }

    }
}