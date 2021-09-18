package PageObject;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class TestTwo {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
    }


    @Test
    public void AuthorTestTwo() {
        driver.get("https://author.today/");
        driver.manage().window().setSize(new Dimension(1296, 696));
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("Login")).click();
        driver.findElement(By.id("Login")).sendKeys("ks.v.efimova@gmail.com");
        driver.findElement(By.cssSelector("div > form:nth-child(2)")).click();
        driver.findElement(By.name("Password")).sendKeys("19972002");
        Assert.assertEquals("Ошибка при вводе логина", "ks.v.efimova@gmail.com", driver.findElement(By.name("username")).getAttribute("value"));
        Assert.assertEquals("Ошибка при вводе пароля", "1992xenia_0", driver.findElement(By.name("password")).getAttribute("value"));
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector(".icon-bell-o")).click();
        loginPage.btn2In();
        loginPage.btn2In();
        loginPage.btn2In();
        driver.findElement(By.linkText("Выйти")).click();
    }

    @AfterClass
    public static void tearDown() {

        driver.quit();
    }
}