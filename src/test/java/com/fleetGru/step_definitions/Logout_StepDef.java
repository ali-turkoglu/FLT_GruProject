package com.fleetGru.step_definitions;

import com.fleetGru.pages.HomePage;
import com.fleetGru.pages.LoginPage;
import com.fleetGru.utilities.BrowserUtils;
import com.fleetGru.utilities.ConfigurationReader;
import com.fleetGru.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout_StepDef {

    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();


    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        loginPage.goLoginPage();
        loginPage.loginAsUserType("Driver");
    }

    @When("User opens profile menu")
    public void user_opens_profile_menu() {
        HomePage.userInfo.click();
    }

    @When("User clicks logout link")
    public void user_clicks_logout_link() {
        homePage.logoutButton.click();
    }

    @Then("User lands on login page")
    public void user_lands_on_login_page() {
        Assert.assertTrue(loginPage.loginHeader.isDisplayed());
    }

    @When("User clicks on the step back button")
    public void user_clicks_on_the_step_back_button() {
        Driver.getDriver().navigate().back();
    }

    @Then("User can not go to homepage")
    public void user_can_not_go_to_homepage() {
        //Assert.assertTrue(loginPage.loginHeader.isDisplayed());
        String actualTitle=Driver.getDriver().getTitle();
        String unexpectedTitle="Dashboard";
        Assert.assertNotEquals(unexpectedTitle,actualTitle);
    }


    String window1;
    String window2;
    @When("User opens two homepage tab")
    public void user_opens_two_homepage_tab() {
        BrowserUtils.openNewTab(ConfigurationReader.get("url"));
        BrowserUtils.openNewTab("");
    }

    @When("User closes all the open tabs")
    public void user_closes_all_the_open_tabs() {
        BrowserUtils.closeSpecificTab("Dashboard");
        BrowserUtils.closeSpecificTab("Dashboard");
    }

    @When("User reopen the url")
    public void user_reopen_the_url() {
        //BrowserUtils.sleep(5);
        Driver.getDriver().get(ConfigurationReader.get("url"));
        BrowserUtils.closeSpecificTab("");
    }

    @Then("User can not land on the homepage")
    public void user_can_not_land_on_the_homepage() {
        String unexpectedTitle="Dashboard";
        String actualTitle=Driver.getDriver().getTitle();
        BrowserUtils.sleep(2);
        Assert.assertNotEquals(unexpectedTitle,actualTitle);
    }

}
