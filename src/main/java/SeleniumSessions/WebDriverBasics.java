package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        String title = driver.getTitle();
        System.out.println("Page title is :" +title);

        //Validation Point:
        if(title.equals("Google")){
            System.out.println("Correct Title");
        }
        else{
            System.out.println("Incorrect Title");
        }

        driver.quit();
    }
}
