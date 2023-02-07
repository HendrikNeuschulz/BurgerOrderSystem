package com.example.burgerordersystem.Service;
import com.example.burgerordersystem.Model.Menu;

import com.example.burgerordersystem.Repository.MenuRepo;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;


@DisplayName("BurgerService Test")
class BurgerServiceTest {
	Menu menuMock;
	Menu menu = new Menu(1, "Burger", new BigDecimal(1000), null, null, null);
	MenuRepo menuRepoMock;
	BurgerService burgerService;
	BurgerService burgerServiceMock;
	@BeforeEach
	void setUpTestingEnvironment() {
		//Given
		menuMock = mock(Menu.class);
//      BurgerService burgerService = mock(BurgerService.class);
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

}