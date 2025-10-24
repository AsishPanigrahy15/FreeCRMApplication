package com.qa.freecrm.tests;

import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.commons.Constants;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.util.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {

    BasePage basePage;
    WebDriver driver;
    Properties prop;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage();
        prop = basePage.initializeProperties();
        driver = basePage.initializeDriver(prop);
        driver.get(prop.getProperty("url"));
        CommonUtil.mediumWait();
        loginPage = new LoginPage(driver);
        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        CommonUtil.longWait();
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String title = homePage.getHomePageTitle();
        System.out.println("Home Page title is :" +title);
        Assert.assertEquals(title, Constants.HOMEPAGE_TITLE, "HomePage title is not matched");
    }

    @Test(priority = 2)
    public void verifyHomePageHeaderTest(){
        String headerText = homePage.getHomePageHeader();
        System.out.println("Home Page Header text is :" +headerText);
        Assert.assertEquals(headerText, Constants.HOMEPAGE_Header, "Home Page header is not matched");
    }

    @Test(priority = 5)
    public void verifySetUpLink(){
        boolean isSetUpLink = homePage.setupLink();
        Assert.assertTrue(isSetUpLink,"Set Up Link is not displayed");
    }

    @Test(priority = 3)
    public void verifyHelpLink(){
        boolean isHelpLink = homePage.helpLink();
        Assert.assertTrue(isHelpLink,"Help Link is not displayed");
    }

    @Test(priority = 4)
    public void verifyLogOutLink(){
        boolean isLogOutLink = homePage.logOutLink();
        Assert.assertTrue(isLogOutLink,"Logout Link is not displayed");
    }

    @Test(priority = 6)
    public void verifyLogOutApp(){
        homePage.logOutApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
