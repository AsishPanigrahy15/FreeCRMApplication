package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?entry_point=login");
        driver.manage().window().maximize();

        By day = By.id("day");
        By month = By.id("month");
        By year = By.id("year");

        selectValueFromDropDown(day, "20", driver);
        selectValueFromDropDown(month, "Nov", driver);
        selectValueFromDropDown(year, "2025", driver);

        driver.quit();
    }

    public static WebElement getWebElement(By selector, WebDriver driver){
        WebElement element = driver.findElement(selector);
        return element;
    }

    public static void selectValueFromDropDown(By selector, String value, WebDriver driver){
        WebElement ele = getWebElement(selector,driver);
        Select select = new Select(ele);
        select.selectByVisibleText(value);
    }
}
