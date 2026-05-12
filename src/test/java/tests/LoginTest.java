package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test (priority = 1,
            description = "Проверка авторизации с валидными кредами",
            testName = "Проверка авторизации с валидными кредами",
            groups = {"smoke"})
    @Description("Проверка авторизации с валидными кредами")
    @Epic("E2E")
    @Feature("Login in to SauceDemo")
    @Story("Positive Login")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com")
    @TmsLink("SD-01")
    @Issue("SD-01")
    @Flaky
    @Owner("Kesaeva Valeriya")
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
    @Description("Проверка авторизации с НЕвалидными кредами")
    @Epic("E2E")
    @Feature("Login in to SauceDemo")
    @Story("Negative Login")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com")
    @TmsLink("SD-02")
    @Issue("SD-02")
    @Owner("Kesaeva Valeriya")
    public void negativeLogin(String username, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}
