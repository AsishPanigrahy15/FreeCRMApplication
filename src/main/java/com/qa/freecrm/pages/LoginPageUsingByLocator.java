package com.qa.freecrm.pages;

import com.qa.freecrm.util.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageUsingByLocator {

    WebDriver driver;
    ElementActions elementActions;


    //1. Define page objects with the help of By locator

    By emailId = By.name("username");
    By password = By.name("password");
    By loginButton = By.xpath("//*[@value = 'Login']");
    By signUp = By.linkText("Sign Up");
    By pricing = By.linkText("Pricing");
    By features = By.linkText("Features");
    By customers = By.linkText("Customers");
    By contact = By.linkText("Contact");

    public LoginPageUsingByLocator(WebDriver driver){
        this.driver = driver;
        elementActions = new ElementActions(driver);
    }

    //2. page actions/methods of the feature

    public String getLoginPageTitle(){
        return elementActions.getPageTitle();
    }

    public HomePage doLogin(String userName, String pwd){
//        elementActions.getElement(emailId).sendKeys(userName);
//        elementActions.getElement(password).sendKeys(pwd);
//        elementActions.getElement(loginButton).click();

        elementActions.sendKeysElement(emailId, userName);
        elementActions.sendKeysElement(password, userName);
        elementActions.clickOnElement(loginButton);
        return new HomePage(driver);
    }

    public boolean signUpLink(){
        boolean bool = elementActions.getElement(signUp).isDisplayed();
        return bool;
    }

    public boolean pricingLink(){
        boolean bool = elementActions.getElement(pricing).isDisplayed();
        return bool;
    }

    public boolean featuresLink(){
        boolean bool = elementActions.getElement(features).isDisplayed();
        return bool;
    }

    public boolean customersLink(){
        boolean bool = elementActions.getElement(customers).isDisplayed();
        return bool;
    }

    public boolean contactLink(){
        boolean bool = elementActions.getElement(contact).isDisplayed();
        return bool;
    }
}
