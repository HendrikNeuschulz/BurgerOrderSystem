package com.example.burgerordersystem.Service;
import com.example.burgerordersystem.Model.Beverage;
import com.example.burgerordersystem.Model.MainDish;
import com.example.burgerordersystem.Model.Menu;

import com.example.burgerordersystem.Model.SideDish;
import com.example.burgerordersystem.Repository.MenuRepo;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;


@DisplayName("BurgerService Test")
class BurgerServiceTest {
	Menu menuMock;
	MenuRepo menuRepoMock;
	@MockBean
	BurgerService burgerService;
	BurgerService burgerServiceMock;

	Menu invalidMenu;
	@BeforeEach
	void setUpTestingEnvironment() {
		//Given
		invalidMenu = new Menu() {
			{
				setId(1);
				setName("New invalid menu because of the forgotten side dish");
				setPrice(new BigDecimal(1000));
				setMainDish(MainDish.HAMBURGER);
				setSideDish(null);
				setBeverage(Beverage.HOT_BEVERAGE);
			}
		};

		menuRepoMock = mock(MenuRepo.class);
		burgerService = new BurgerService();
		// burgerServiceMock = mock(BurgerService.class);
	}

	@Nested
	@DisplayName("Test for getAllMenus()")
	class getAllMenus {
		@Test
		@DisplayName("returns an empty list when the repository is empty")
		void getAllMenus_shouldReturnAllMenusOfAnEmptyRepository() {
			//When
			List<Menu> actual = burgerService.getMenus();
//			when(burgerService.getMenus()).thenReturn(new ArrayList<Menu>() {});

			//Then
			Assertions.assertEquals(new ArrayList<Menu>(), actual);
		}

		@Test
		@DisplayName("returns a list of menus when the repository is not empty")
		@DirtiesContext
		void getAllMenus_shouldReturnAllMenusOfANonEmptyRepository() {
			//When
			burgerService.addMenu(menuMock);
			List<Menu> actual = burgerService.getMenus();
			List<Menu> expected = new ArrayList<Menu>() {{add(menuMock);}};

			//Then
			Assertions.assertEquals(expected, actual);
		}
	}

	@Nested
	@DisplayName("Test for getMenuById()")
	class getMenuById {

		@Test
		@DisplayName("returns a menu when the repository contains a menu with given id")
		void getMenuById_shouldReturnAMenuWhenTheRepositoryContainsAMenuWithGivenId() {
			//When
			Optional expected =  Optional.ofNullable(menuMock);
			//Then
			Assertions.assertEquals(expected, burgerService.getMenuById(1));
		}

		@Test
		@DisplayName("returns null when the repository does not contain a menu with given id")
		void getMenuById_shouldReturnNullWhenTheRepositoryDoesNotContainAMenuWithGivenId() {

			//Then
			Assertions.assertEquals(Optional.ofNullable(null), burgerService.getMenuById(1));
		}
	}

	@Nested
	@DisplayName("Test for addMenu()")
	class addMenu {
		@Test
		@DisplayName("adds a menu tho the repository and returns the updated list of menus if the menu to be added is valid")
		void addMenu_shouldAddMenuToTheRepositoryAndReturnTheUpdatedMenuList() {
			// When
			when(menuMock.getId()).thenReturn(1); // these whole things could be refactored into a method of Menu class, like menu.isValid()
			when(menuMock.getName()).thenReturn("Burger");
			when(menuMock.getPrice()).thenReturn(new BigDecimal(1000));
			when(menuMock.getMainDish()).thenReturn(MainDish.HAMBURGER);
			when(menuMock.getSideDish()).thenReturn(SideDish.FARM_WEDGES);
			when(menuMock.getBeverage()).thenReturn(Beverage.HOT_BEVERAGE);

			when(menuRepoMock.addMenu(new Menu()));

			// Then
			Assertions.assertEquals(new ArrayList<Menu>() {
				{
					add(menuMock);
				}
			}, burgerService.addMenu(menuMock));
		}

		@Test
		@DisplayName("returns null when the menu to be added is invalid")
		void addMenu_shouldReturnNullWhenTheMenuToBeAddedIsInvalid() {
			// When

//			when(menuMock.getId()).thenReturn(1);
//			when(menuMock.getName()).thenReturn("New invalid menu because of the forgotten side dish");
//			when(menuMock.getPrice()).thenReturn(new BigDecimal(1000));
//			when(menuMock.getMainDish()).thenReturn(MainDish.HAMBURGER);
//			when(menuMock.getSideDish()).thenReturn(null);
//			when(menuMock.getBeverage()).thenReturn(Beverage.HOT_BEVERAGE);

			when(menuRepoMock.addMenu(invalidMenu)).thenReturn(null);

			//Then
			Assertions.assertEquals(null, burgerService.addMenu(invalidMenu));
		}

	}

}