package com.cydeo.step_definitions;

import com.cydeo.pages.BooksPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();
    BooksPage booksPage=new BooksPage();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }
    @When("I login as a student")
    public void i_login_as_a_student() {
//        loginPage.inputEmail.sendKeys(ConfigurationReader.getProperty("student27_user"));
//        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("student27_pass"));
//        loginPage.buttonSign.click();
        loginPage.login("student27_user","student27_pass");

    }
    @Then("books should be displayed")
    public void books_should_be_displayed() {
        BrowserUtils.waitForURLContains("books");
        BrowserUtils.verifyURLContains("books");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.inputEmail.sendKeys(username);
    }


    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.inputPassword.sendKeys(password);
    }

    @And("click the sign in button")
    public void clickTheSignInButton() {
        loginPage.buttonSign.click();
    }



    @And("there should be {int} entries")
    public void thereShouldBeEntries(int expectedEntryAmount) {
        BrowserUtils.waitForVisibility(booksPage.entryCount,2);
        String actualEntryCount = booksPage.entryCount.getText();
        System.out.println("actualEntryCount = " + actualEntryCount);
        String expectedEntryCount = String.valueOf(expectedEntryAmount);
        System.out.println("expectedEntryCount = " + expectedEntryCount);
        Assert.assertTrue(actualEntryCount.replace("," , "").contains(expectedEntryCount));
    }
}