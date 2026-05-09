package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test (priority = 1,
    description = "Проверка количества отображаемых товаров на странице",
    testName = "Проверка количества отображаемых товаров на странице",
    groups = {"smoke"})
    public void findProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),"Products");
        assertEquals(productsPage.getProductsCount(), 6, "На странице должно быть 6 товаров");
    }
}
