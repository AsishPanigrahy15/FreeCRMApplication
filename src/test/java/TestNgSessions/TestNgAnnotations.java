package TestNgSessions;

import org.testng.annotations.*;

public class TestNgAnnotations {

    /*
    launchBrowser
    connectionWithDB
    launchUrl
            loginToApp
            verifyHomePageHeader
            logOut

            loginToApp
            verifyHomePageTitle
            logOut

            loginToApp
            verifySearchTest
            logOut

    closeBrowserConnection
    closeDbConnection
    closeBrowser
    */

    @BeforeSuite
    public void launchBrowser(){
        System.out.println("launchBrowser");
    }

    @BeforeTest
    public void connectionWithDB(){
        System.out.println("connectionWithDB");
    }

    @BeforeClass
    public void launchUrl(){
        System.out.println("launchUrl");
    }

    @BeforeMethod
    public void loginToApp(){
        System.out.println("loginToApp");
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        System.out.println("verifyHomePageTitle");
    }

    @Test(priority = 3)
    public void verifyHomePageHeaderTest(){
        System.out.println("verifyHomePageHeader");
    }

    @Test(priority = 2, enabled = false) //To ignore the test
    public void verifySearchTest(){
        System.out.println("verifySearchTest");
    }

    @AfterMethod
    public void logOut(){
        System.out.println("logOut");
    }

    @AfterClass
    public void closeBrowserConnection(){
        System.out.println("closeBrowserConnection");
    }

    @AfterTest
    public void closeDbConnection(){
        System.out.println("closeDbConnection");
    }

    @AfterSuite
    public void closeBrowser(){
        System.out.println("closeBrowser");
    }
}
