package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class CartTest extends BaseTest {

    @Test (priority = 1,
            description = "Проверка добавления товара в корзину",
            testName = "Проверка добавления товара в корзину",
            groups = {"smoke"})
    @Description("Проверка добавления товара в корзину")
    @Epic("E2E")
    @Feature("Carts in SauceDemo")
    @Story("Carts")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com")
    @TmsLink("SD-04")
    @Issue("SD-04")
    @Owner("Kesaeva Valeriya")
    public void addToCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),"Products");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        assertTrue(cartPage.findToCart( "Sauce Labs Backpack"));
    }

    @Test (priority = 2,
            description = "Проверка удаления товара из корзины",
            testName = "Проверка удаления товара из корзины",
            groups = {"smoke"})
    @Description("Проверка удаления товара из корзины")
    @Epic("E2E")
    @Feature("Carts in SauceDemo")
    @Story("Carts")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com")
    @TmsLink("SD-05")
    @Issue("SD-05")
    @Owner("Kesaeva Valeriya")
    public void deleteToCart() {

            loginPage.open();
            loginPage.login("standard_user", "secret_sauce");
            assertEquals(productsPage.getTitle(),"Products");
            productsPage.addToCart("Sauce Labs Backpack");
            cartPage.open();
            assertTrue(cartPage.findToCart( "Sauce Labs Backpack"));
            cartPage.deleteToCart("Sauce Labs Backpack");
            assertFalse(cartPage.findToCart("Sauce Labs Backpack"));
        }
    }
