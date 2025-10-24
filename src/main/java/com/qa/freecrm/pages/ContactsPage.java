package com.qa.freecrm.pages;

import com.qa.freecrm.base.BasePage;
import com.qa.freecrm.commons.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPage extends BasePage {

    WebDriver driver;

    //WebElements:
    @FindBy(xpath = "//*[@value='New Contact']")
    WebElement newContact;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "surname")
    WebElement surName;

    @FindBy(name = "client_lookup")
    WebElement company;

    @FindBy(id = "phone")
    WebElement phoneNo;

    @FindBy(id = "mobile")
    WebElement mobileNo;

    @FindBy(id = "home_phone")
    WebElement homePhoneNo;

    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(xpath = "//*[@value='Save']")
    WebElement saveBtn;


    //Constructor:
    public ContactsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewContact(String fName, String lName, String companyName, String phone, String mobile, String homePhone, String email){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_EXPLICIT_WAIT));

        wait.until(ExpectedConditions.elementToBeClickable(newContact));
        newContact.click();

        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.sendKeys(fName);

        wait.until(ExpectedConditions.elementToBeClickable(surName));
        surName.sendKeys(lName);

        wait.until(ExpectedConditions.elementToBeClickable(company));
        company.sendKeys(companyName);

        wait.until(ExpectedConditions.elementToBeClickable(phoneNo));
        phoneNo.sendKeys(phone);

        wait.until(ExpectedConditions.elementToBeClickable(mobileNo));
        mobileNo.sendKeys(mobile);

        wait.until(ExpectedConditions.elementToBeClickable(homePhoneNo));
        homePhoneNo.sendKeys(homePhone);

        wait.until(ExpectedConditions.elementToBeClickable(emailId));
        emailId.sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
    }
}
