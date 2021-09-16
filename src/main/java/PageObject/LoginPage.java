package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(linkText = "Подборки произведений")
    private WebElement btn1;

    @FindBy(css = ".avatar")
    private WebElement btn2;


    public void btn1In (){
        btn1.click();
    }

    public void btn2In(){
        btn2.click();
    }

    public void logoIn(String login) {
        emailField.sendKeys(login);
    }

    public void passwdIn(String password) {
        emailField.sendKeys(password);
    }
}