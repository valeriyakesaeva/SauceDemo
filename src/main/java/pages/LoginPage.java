package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.xpath("//*[@data-test='username']");
    private final By PASSWORD_FIELD = By.xpath("//*[@data-test='password']");
    private final By LOGIN_BUTTON = By.xpath("//*[@data-test='login-button']");
    private final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Открытие страницы авторизации")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Step("Вход в магазин с именем пользователя: '{user}' и паролем: '{password}'")
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
    return driver.findElement(ERROR_MESSAGE).getText();
    }
}
