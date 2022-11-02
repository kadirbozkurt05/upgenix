package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class LoginFuncStepDefs {
    private LoginPage loginPage = new LoginPage();

    private String env = ConfigReader.getProperty("env");
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    @When("user goes to login page")
    public void userGoesToLoginPage() {
        Driver.getDriver().get(env);
    }

    @When("salesmanager enters {string} to to email input")
    public void salesmanagerEntersToToEmailInput(String email) {
        loginPage.emailInput.sendKeys(email);
    }

    @And("salesmanager enter {string} to password input")
    public void salesmanagerEnterToPasswordInput(String password) {
        loginPage.passwordInput.sendKeys(password);
    }


    @Then("salesmanager should see the #Inbox - Odoo as title")
    public void salesmanagerShouldSeeTheInboxOdooAsTitle() {
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        String expectedTitle = "#Inbox - Odoo";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("posmanager enters {string} to to email input")
    public void posmanagerEntersToToEmailInput(String email) {
        loginPage.emailInput.sendKeys(email);
    }

    @And("posmanager enter {string} to password input")
    public void posmanagerEnterToPasswordInput(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @And("user press Enter")
    public void posmanagerPressEnter() {
        loginPage.passwordInput.sendKeys(Keys.ENTER);
    }

    @Then("posmanager should see the #Inbox - Odoo as title")
    public void posmanagerShouldSeeTheInboxOdooAsTitle() {
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        String expectedTitle = "#Inbox - Odoo";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @And("user clicks login button")
    public void posmanagerClicksLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("user should see the Wrong login password message")
    public void userShouldSeeTheWrongLoginPasswordMessage() {
        Assert.assertTrue(loginPage.wrongMailOrPassword.isDisplayed());
    }


    @Then("verify email input has error message attribute")
    public void verifyEmailInputHasErrorMessageAttribute() {
        String message = loginPage.emailInput.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field.",message);
    }

    @Then("verify password input has error message attribute")
    public void verifyPasswordInputHasErrorMessageAttribute() {
        String message = loginPage.passwordInput.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field.",message);
    }

}
