import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

public class CartTest {

    @Test
    public void checkCart() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement input = driver.findElement(By.id("user-name"));
        input.sendKeys("standard_user");
        WebElement input1 = driver.findElement(By.name("password"));
        input1.sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[value='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement name = driver.findElement(By.className("inventory_item_name"));
        String value = name.getText();
        Assert.assertEquals(value, "Sauce Labs Backpack");
        WebElement price = driver.findElement(By.className("inventory_item_price"));
        String value1 = price.getText();
        Assert.assertEquals(value1, "$29.99");
        driver.quit();
    }
}