package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='login']")
    public WebElement emailInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(css = ".btn.btn-primary")
    public WebElement loginButton;
    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement wrongMailOrPassword;
}
