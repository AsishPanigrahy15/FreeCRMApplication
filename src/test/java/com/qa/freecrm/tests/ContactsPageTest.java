package com.qa.freecrm.tests;

import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.pages.ContactsPage;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.util.CommonUtil;
import com.qa.freecrm.util.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Properties;

public class ContactsPageTest {

    BasePage basePage;
    WebDriver driver;
    Properties prop;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage();
        prop = basePage.initializeProperties();
        driver = basePage.initializeDriver(prop);
        driver.get(prop.getProperty("url"));
        CommonUtil.mediumWait();
        loginPage = new LoginPage(driver);
        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        CommonUtil.mediumWait();
        contactsPage = homePage.goToContactsPage();
    }

    @DataProvider (name = "getContactsData")
    public Object[][] getContactTestData(){
        Object[][] contactsData = ExcelUtil.getTestData("Contacts");
        return contactsData;
    }

    @Test(dataProvider = "getContactsData")
    public void createContactTest(String fName, String lName, String companyName, String phone, String mobile, String homePhone, String email){
        contactsPage.createNewContact(fName, lName, companyName, phone, mobile, homePhone, email);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
