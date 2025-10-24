package com.qa.freecrm.pages;

import com.qa.freecrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    //1. Define page objects with the help of page factory OR By locator
    //2. page actions/methods of the feature

    WebDriver driver;

    @FindBy(name = "username")
    WebElement emailId;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//*[@value = 'Login']")
    WebElement loginButton;

    @FindBy(linkText = "Sign Up")
    WebElement signUp;

    @FindBy(linkText = "Pricing")
    WebElement pricing;

    @FindBy(linkText = "Features")
    WebElement features;

    @FindBy(linkText = "Customers")
    WebElement customers;

    @FindBy(linkText = "Contact")
    WebElement contact;

    //3.Create a constructor of page class and initialize all the page objects with driver

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //4. Define your actions/methods:

    public String getLoginPageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public HomePage doLogin(String userName, String pwd){
        emailId.sendKeys(userName);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage(driver);
    }

    public boolean signUpLink(){
        boolean bool = signUp.isDisplayed();
        return bool;
    }

    public boolean pricingLink(){
        boolean bool = pricing.isDisplayed();
        return bool;
    }

    public boolean featuresLink(){
        boolean bool = features.isDisplayed();
        return bool;
    }

    public boolean customersLink(){
        boolean bool = customers.isDisplayed();
        return bool;
    }

    public boolean contactLink(){
        boolean bool = contact.isDisplayed();
        return bool;
    }
}
