package com.qa.freecrm.tests;

import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.commons.Constants;
import com.qa.freecrm.pages.LoginPageUsingByLocator;
import com.qa.freecrm.util.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTestUsingByLocator {

    BasePage basePage;
    WebDriver driver;
    Properties prop;
    LoginPageUsingByLocator loginPageUsingByLocator;

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage();
        prop = basePage.initializeProperties();
        driver = basePage.initializeDriver(prop);
        driver.get(prop.getProperty("url"));
        CommonUtil.mediumWait();
        loginPageUsingByLocator = new LoginPageUsingByLocator(driver);
    }

    @Test(priority = 1)
    public void verifyLoginPageTitleTest(){
        String loginPageTitle =  loginPageUsingByLocator.getLoginPageTitle();
        System.out.println("Login Page title is :" +loginPageTitle);
        Assert.assertEquals(loginPageTitle, Constants.LOGINPAGE_TITLE, "Login Page title is not matched");
    }

    @Test(priority = 3)
    public void verifySignUpLink(){
        boolean isSignUpLink = loginPageUsingByLocator.signUpLink();
        Assert.assertTrue(isSignUpLink,"Sign Up Link is not displayed");
    }

    @Test(priority = 2)
    public void verifyPricingLink(){
        boolean isPricingLink = loginPageUsingByLocator.pricingLink();
        Assert.assertTrue(isPricingLink,"Pricing Link is not displayed");
    }

    @Test(priority = 4)
    public void verifyFeaturesLink(){
        boolean isFeaturesLink = loginPageUsingByLocator.featuresLink();
        Assert.assertTrue(isFeaturesLink,"Features Link is not displayed");
    }

    @Test(priority = 5)
    public void verifyCustomersLink(){
        boolean isCustomerLink = loginPageUsingByLocator.customersLink();
        Assert.assertTrue(isCustomerLink,"Customer Link is not displayed");
    }

    @Test(priority = 6)
    public void verifyContactLink(){
        boolean isContactLink = loginPageUsingByLocator.contactLink();
        Assert.assertTrue(isContactLink,"Contact Link is not displayed");
    }

    @Test(priority = 7)
    public void verifyLoginTest(){
        loginPageUsingByLocator.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
