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

    @Step("Открытие страницы авторизации")
    public void open() {
        driver.get(BASE_URL);
    }

    public void isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Step("Вход в магазин с именем пользователя: '{user}' и паролем: '{password}'")
    public void login(String username, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
    return driver.findElement(ERROR_MESSAGE).getText();
    }
}
