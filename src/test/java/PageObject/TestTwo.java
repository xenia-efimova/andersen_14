package PageObject;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class TestTwo {
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
    public void AuthorTestTwo() {
        driver.get("https://author.today/");
        driver.manage().window().setSize(new Dimension(1296, 696));
        loginPage.btn1In();
        driver.findElement(By.id("Login")).click();
        loginPage.logoIn(ConfProperties.getProperty("login"));
        Assert.assertEquals("ks.v.efimova@gmail.com", ConfProperties.getProperty("login"));
        driver.findElement(By.cssSelector("div > form:nth-child(2)")).click();
        loginPage.passwdIn(ConfProperties.getProperty("password"));
        Assert.assertEquals("1992xeniaefi", ConfProperties.getProperty("password"));
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector(".icon-bell-o")).click();
        loginPage.btn2In();
        driver.findElement(By.linkText("Выйти")).click();
    }
}