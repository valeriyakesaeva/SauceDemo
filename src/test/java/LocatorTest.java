import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class LocatorTest {

    @Test
    public void checkLocator() {
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
        driver.findElement(By.cssSelector("#login-button"));
        driver.findElement(By.cssSelector(".login_logo"));
        driver.findElement(By.cssSelector(".submit-button.btn_action"));
        driver.findElement(By.cssSelector(".form_group .input_error.form_input"));
        driver.findElement(By.cssSelector("input[id=login-button]"));
        driver.findElement(By.cssSelector("[value='Login']"));
        driver.findElement(By.cssSelector("[class~='btn_action']"));
        driver.findElement(By.cssSelector("[id|='login']"));
        driver.findElement(By.cssSelector("[id^='login']"));
        driver.findElement(By.cssSelector("[id$='name']"));
        driver.findElement(By.cssSelector("[name*='user']"));
        driver.findElement(By.className("form_group"));
        WebElement input = driver.findElement(By.id("user-name"));
        input.sendKeys("standard_user");
        WebElement input1 = driver.findElement(By.name("password"));
        input1.sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[id=login-button]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.tagName("footer"));
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        driver.findElement(By.partialLinkText("Backpack"));
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//div[contains(text(),'Swag')]"));
        driver.findElement(By.xpath("//div[contains(@class,'cart_quantity')]"));
        driver.findElement(By.xpath("//div[@class='cart_desc_label' and @data-test='cart-desc-label']"));
        driver.findElement(By.xpath("//button[@id='continue-shopping']/parent::div"));
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//div[@class='checkout_info']//descendant::input[@id='last-name']"));
        driver.findElement(By.xpath("//input[@id='first-name']//ancestor::div[@class='checkout_info']"));
        driver.findElement(By.xpath("//input[@id='postal-code']//preceding::input[@id='last-name']"));
        driver.findElement(By.xpath("//input[@id='first-name']//following::input[@id='last-name']"));
        driver.quit();
    }
}
