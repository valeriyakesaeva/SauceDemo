package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By TITLE = By.cssSelector("[data-test='title']");

    @Override
    @Step("Открытие страницы корзина")
    public CartPage open() {
        driver.get(BASE_URL + "/cart.html");
        return this;
    }

    @Override
    public CartPage isPageOpened() {
        return this;
    }

    public boolean findToCart(String product) {
        String FIND_TO_CART_PATTERN =
                "//*[text()='%s']/ancestor::div[@class='cart_item']";
        return driver.findElements(By.xpath(String.format(FIND_TO_CART_PATTERN, product))).size() > 0;
    }

    @Step("Удаление товара с именем: '{product}' из корзины")
    public CartPage deleteToCart(String product) {
        String DELETE_TO_CART_PATTERN =
                "//*[text()='%s']/ancestor::div[@class='cart_item']//button[text()='Remove']";
         driver.findElement(By.xpath(String.format(DELETE_TO_CART_PATTERN, product))).click();
         return this;
    }
}
