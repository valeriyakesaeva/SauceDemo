package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test (priority = 1,
            description = "Проверка авторизации с валидными кредами",
            testName = "Проверка авторизации с валидными кредами",
            groups = {"smoke"})
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),"Products");
    }

    @DataProvider(name = "Тестовые данные для негативных проверок авторизации")
    public Object[][] loginData() {
        return new Object[][] {
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test (dataProvider = "Тестовые данные для негативных проверок авторизации", priority = 2,
            description = "Проверка авторизации с НЕвалидными кредами",
            testName = "Проверка авторизации с НЕвалидными кредами",
            groups = {"regression"})
    public void negativeLogin(String username, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}
