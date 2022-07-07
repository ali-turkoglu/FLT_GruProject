package com.fleetGru.pages;

import com.fleetGru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "oro-subtitle")
    public WebElement pageSubtitle;

    public String getSubtitle() {
        return pageSubtitle.getText();
    }

    @FindBy(id = "user-menu")
    public static WebElement userInfo;



    public String userInfoGet() {
        return userInfo.getText();
    }


    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;

    @FindBy(linkText = "Fleet Management")
    public WebElement fleetHomepageLink;




}
