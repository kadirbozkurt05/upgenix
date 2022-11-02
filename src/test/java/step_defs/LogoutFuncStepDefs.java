package step_defs;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import utils.Driver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class LogoutFuncStepDefs {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    String homePageUrl = "";
    @When("user enters {string} to to email input")
    public void userEntersToToEmailInput(String email) {
        loginPage.emailInput.sendKeys(email);
    }

    @And("user enters {string}")
    public void userEnters(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("verify that user is on the main page and save the current url")
    public void verifyThatUserIsOnTheMainPageAndSaveTheCurrentUrl() {
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        String expectedTitle = "#Inbox - Odoo";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        homePageUrl = Driver.getDriver().getCurrentUrl();

    }

    @And("user clicks the username at the top right of the page")
    public void userClicksTheUsernameAtTheTopRightOfThePage() {
        mainPage.userMenu.click();
    }

    @And("user clicks Log out link")
    public void userClicksLogOutLink() {
        mainPage.logoutLink.click();
    }

    @And("verify user is on the login page")
    public void verifyUserIsOnTheLoginPage() {
        String expectedTitle = "Login | Best solution for startups";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @And("goes to saved url from home page")
    public void goesToSavedUrlFromHomePage() {
        Driver.getDriver().get(homePageUrl);

    }

    @Then("verify user is not logged in")
    public void verifyUserIsNotLoggedIn() {
        String unExpectedTitle = "#Inbox - Odoo";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertNotEquals(unExpectedTitle,actualTitle);
    }

    @And("user clicks to the back button from browser")
    public void userClicksToTheBackButtonFromBrowser() {
        Driver.getDriver().navigate().back();
    }

    @Then("verify user does not go to the home page")
    public void verifyUserDoesNotGoToTheHomePage() {
        try {
            Assert.assertFalse("Element shouldn't be visible. User is still logged in!",mainPage.userMenu.isDisplayed());
        }catch (NoSuchElementException e){

        }
    }

    @And("user closes the all windows")
    public void userClosesTheAllWindows() throws InterruptedException {
        String link = "window.open('https://www.google.com','_blank');";
        ((JavascriptExecutor)Driver.getDriver()).executeScript(link);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://qa.upgenix.net/web?#menu_id=115&action=120&active_id=channel_inbox','_blank');");

        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        Set<String> windows = new HashSet<>();
        String otherWindow="";

  for (String each : allWindows) {
      Thread.sleep(1000);
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains("upgenix")){
                windows.add(each);
            }else{
                otherWindow = each;
            }
        }

        for (String each : windows) {
            Driver.getDriver().switchTo().window(each);
            Driver.getDriver().close();
        }
        Driver.getDriver().switchTo().window(otherWindow);
    }
}
