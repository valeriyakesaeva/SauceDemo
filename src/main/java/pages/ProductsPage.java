package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test='title']");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final String DELETE_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    private final By INVENTORY_ITEM = By.cssSelector("[data-test='inventory-item']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы с товарами")
    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с именем: '{product}' в корзину")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    @Step("Удаление товара с именем: '{product}' из корзины")
    public void deleteToCart(String product) {
        driver.findElement(By.xpath(String.format(DELETE_TO_CART_PATTERN, product))).click();
    }

    public int getProductsCount() {
        return driver.findElements(INVENTORY_ITEM).size();
    }
}
