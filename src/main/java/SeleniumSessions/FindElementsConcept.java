package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsConcept {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        List<WebElement> webElementList =driver.findElements(By.tagName("a"));
        System.out.println("Total links count is :" +webElementList.size());

        // Print the text of each link - Normal for loop
        for(int i=0; i<webElementList.size(); i++){
            String linkText = webElementList.get(i).getText();
            if(!linkText.isEmpty()){
                System.out.println("Link text is :" +linkText);
            }
        }

        // Print the text of each link - Advance for loop
        for (WebElement webElement : webElementList) {
            String linkText = webElement.getText();
            if (!linkText.isEmpty()) {
                System.out.println("Link text is :" + linkText);
            }
        }

        driver.quit();
    }
}
