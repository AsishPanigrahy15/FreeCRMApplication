package com.qa.freecrm.base;

import com.qa.freecrm.commons.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;

    public WebDriver initializeDriver(Properties prop){

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }
        else{
            System.out.println("Browser not defined");
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIME_OUT));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        return driver;
    }

    public Properties initializeProperties(){
        prop = new Properties();
        try {

            FileInputStream inputStream = new FileInputStream("src/main/java/com/qa/freecrm/configuration/config.properties");;
            prop.load(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}

