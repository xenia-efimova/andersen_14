package PageObject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;


public class TestOne {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void AuthorTestOne() {
        driver.get("https://author.today/");
        driver.manage().window().setSize(new Dimension(688, 680));
        {
            WebElement element = driver.findElement(By.linkText("Войти"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".brand-logo-img")).click();
        loginPage.btn2In();
        driver.findElement(By.cssSelector(".collection:nth-child(2) > .collection-title")).click();
        Assertions.assertEquals(driver.findElement(By.linkText("Апокалипсис. Постапокалипсис. Выживание")).getText(),"Апокалипсис. Постапокалипсис. Выживание");
    }
}