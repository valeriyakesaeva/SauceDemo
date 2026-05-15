package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test='title']");
    private final By INVENTORY_ITEM = By.cssSelector("[data-test='inventory-item']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Открытие страницы с товарами")
    public ProductsPage open() {
        driver.get(BASE_URL + "/inventory.html");
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Override
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Добавление товара с именем: '{product}' в корзину")
    public ProductsPage addToCart(String product) {
        String ADD_TO_CART_PATTERN =
                "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Удаление товара с именем: '{product}' из корзины")
    public ProductsPage deleteToCart(String product) {
        String DELETE_TO_CART_PATTERN =
                "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
        driver.findElement(By.xpath(String.format(DELETE_TO_CART_PATTERN, product))).click();
        return this;
    }

    public int getProductsCount() {
        return driver.findElements(INVENTORY_ITEM).size();
    }
}
