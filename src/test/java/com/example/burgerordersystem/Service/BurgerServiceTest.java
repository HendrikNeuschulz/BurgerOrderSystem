package com.example.burgerordersystem.Service;
import com.example.burgerordersystem.Model.Beverage;
import com.example.burgerordersystem.Model.MainDish;
import com.example.burgerordersystem.Model.Menu;

import com.example.burgerordersystem.Model.SideDish;
import com.example.burgerordersystem.Repository.MenuRepo;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;


@DisplayName("BurgerService Test")
class BurgerServiceTest {
	Menu menuMock;
	MenuRepo menuRepoMock;
	@MockBean
	BurgerService burgerService;
	BurgerService burgerServiceMock;
	@BeforeEach
	void setUpTestingEnvironment() {
		//Given
		menuMock = mock(Menu.class);
		menuRepoMock = mock(MenuRepo.class);
		burgerService = new BurgerService();
		burgerServiceMock = mock(BurgerService.class);
	}

	@Nested
	@DisplayName("Test for getAllMenus()")
	class getAllMenus {
		@Test
		@DisplayName("returns an empty list when the repository is empty")
		void getAllMenus_shouldReturnAllMenusOfAnEmptyRepository() {
			//When
			when(burgerServiceMock.getMenus()).thenReturn(new ArrayList<Menu>() {});

			//Then
			Assertions.assertEquals(new ArrayList<Menu>(), burgerService.getMenus());
		}

		@Test
		@DisplayName("returns a list of menus when the repository is not empty")
		void getAllMenus_shouldReturnAllMenusOfANonEmptyRepository() {
			//When
			when(burgerServiceMock.getMenus()).thenReturn(new ArrayList<Menu>() {
				{
					add(menuMock);
				}
			});

			//Then
			Assertions.assertEquals(
					new ArrayList<Menu>() {{add(menuMock);}},
					burgerService.getMenus()
			);
		}
	}

	@Nested
	@DisplayName("Test for getMenuById()")
	class getMenuById {

		@Test
		@DisplayName("returns a menu when the repository contains a menu with given id")
		void getMenuById_shouldReturnAMenuWhenTheRepositoryContainsAMenuWithGivenId() {
			//When
			when(burgerServiceMock.getMenuById(1)).thenReturn(Optional.ofNullable(menuMock));
			when(menuMock.getId()).thenReturn(1);

			//Then
			Assertions.assertEquals(Optional.of(menuMock), burgerService.getMenuById(menuMock.getId()));
		}

		@Test
		@DisplayName("returns null when the repository does not contain a menu with given id")
		void getMenuById_shouldReturnNullWhenTheRepositoryDoesNotContainAMenuWithGivenId() {
			//When
			when(burgerServiceMock.getMenuById(1)).thenReturn(Optional.ofNullable(null));

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
			when(burgerServiceMock.addMenu(menuMock)).thenReturn(Optional.of(new ArrayList<Menu>() {
				{
					add(menuMock);
				}
			}));
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
			when(menuMock.getId()).thenReturn(1);
			when(menuMock.getName()).thenReturn("New invalid menu because of the forgotten side dish");
			when(menuMock.getPrice()).thenReturn(new BigDecimal(1000));
			when(menuMock.getMainDish()).thenReturn(MainDish.HAMBURGER);
			when(menuMock.getSideDish()).thenReturn(null);
			when(menuMock.getBeverage()).thenReturn(Beverage.HOT_BEVERAGE);
			when(burgerServiceMock.addMenu(menuMock)).thenReturn(null); // This is the line that might be unnecessary, correct Gleb if he's wrong
			//Then
			Assertions.assertEquals(null, burgerService.addMenu(menuMock));
		}

	}

}