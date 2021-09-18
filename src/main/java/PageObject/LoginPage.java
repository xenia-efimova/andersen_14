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

}