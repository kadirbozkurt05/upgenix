package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = ".o_user_menu")
    public WebElement userMenu;
    @FindBy(linkText = "Log out")
    public WebElement logoutLink;

}
