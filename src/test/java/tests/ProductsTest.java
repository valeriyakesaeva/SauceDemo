package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test (priority = 1,
    description = "Проверка количества отображаемых товаров на странице",
    testName = "Проверка количества отображаемых товаров на странице",
    groups = {"smoke"})
    @Description("Проверка количества отображаемых товаров на странице")
    @Epic("E2E")
    @Feature("Products in SauceDemo")
    @Story("Products")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://www.saucedemo.com")
    @TmsLink("SD-03")
    @Issue("SD-03")
    @Owner("Kesaeva Valeriya")
    public void findProducts() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        assertEquals(productsPage.getTitle(),"Products");
        assertEquals(productsPage.getProductsCount(), 6, "На странице должно быть 6 товаров");
    }
}
