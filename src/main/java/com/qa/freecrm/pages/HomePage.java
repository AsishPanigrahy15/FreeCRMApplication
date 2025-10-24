package com.qa.freecrm.pages;

import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.util.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    WebDriver driver;

    //WebElements:
    @FindBy(linkText = "Upgrade your account")
    WebElement homePageHeader;

    @FindBy(linkText = "Setup")
    WebElement setUpLink;

    @FindBy(linkText = "Help")
    WebElement helpLink;

    @FindBy(linkText = "Logout")
    WebElement logOutLink;

    @FindBy(xpath = "//*[@title='Contacts']")
    WebElement contacts;

    //Constructor:
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions or Methods:
    public String getHomePageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String getHomePageHeader(){
        driver.switchTo().frame("mainpanel");
        String header = homePageHeader.getText();
        return header;
    }

    public boolean setupLink(){
        driver.switchTo().frame("mainpanel");
        boolean bool = setUpLink.isDisplayed();
        return bool;
    }

    public boolean helpLink(){
        driver.switchTo().frame("mainpanel");
        boolean bool = helpLink.isDisplayed();
        return bool;
    }

    public boolean logOutLink(){
        driver.switchTo().frame("mainpanel");
        boolean bool = logOutLink.isDisplayed();
        return bool;
    }

    public void logOutApp(){
        driver.switchTo().frame("mainpanel");
        logOutLink.click();
    }

    public ContactsPage goToContactsPage(){
        driver.switchTo().frame("mainpanel");
        CommonUtil.shortWait();
        contacts.click();
        return new ContactsPage(driver);
    }

}
