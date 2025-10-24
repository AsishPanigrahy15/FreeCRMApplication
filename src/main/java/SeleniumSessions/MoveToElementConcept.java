package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.devmedia.com.br/");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        WebElement courseMenu = driver.findElement(By.xpath("//span[@class='menu-item-link submenu-show'][2]"));
        action.moveToElement(courseMenu).build().perform();

        WebElement javaCourse = driver.findElement(By.linkText("Java"));
        javaCourse.click();

        driver.quit();

    }
}
