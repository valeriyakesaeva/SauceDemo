package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class CartTest extends BaseTest {

    @Test
    public void addToCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),"Products");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        assertTrue(cartPage.findToCart( "Sauce Labs Backpack"));
    }
    @Test
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
