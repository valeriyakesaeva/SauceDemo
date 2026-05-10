package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By TITLE = By.cssSelector("[data-test='title']");
    private final String FIND_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='cart_item']";
    private final String DELETE_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='cart_item']//button[text()='Remove']";

    @Step("Открытие страницы корзина")
    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public boolean findToCart(String product) {
        return driver.findElements(By.xpath(String.format(FIND_TO_CART_PATTERN, product))).size() > 0;
    }

    @Step("Удаление товара с именем: '{product}' из корзины")
    public void deleteToCart(String product) {
         driver.findElement(By.xpath(String.format(DELETE_TO_CART_PATTERN, product))).click();
    }
}
