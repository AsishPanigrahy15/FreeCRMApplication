package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WebTable {

    static WebDriver driver;

    public static void main(String[] args) {
        driver = WebDriverFactory.getDriver("https://www.w3schools.com/html/html_tables.asp");

        //*[@id="customers"]/tbody/tr[2]/td[1]
        //*[@id="customers"]/tbody/tr[3]/td[1]
        //*[@id="customers"]/tbody/tr[4]/td[1]
        //*[@id="customers"]/tbody/tr[5]/td[1]
        //*[@id="customers"]/tbody/tr[6]/td[1]
        //*[@id="customers"]/tbody/tr[7]/td[1]

        String comp_before_xpath = "//*[@id='customers']/tbody/tr[";
        String comp_after_xpath = "]/td[1]";

        ArrayList<String> compList = getColumnData(comp_before_xpath, comp_after_xpath);
        System.out.println(compList);

        HashMap<Integer, String> hashMap = getColumnDataMap(comp_before_xpath,comp_after_xpath);
        System.out.println(hashMap);

//        List<WebElement> companyList = driver.findElements(By.xpath("//table[@id='customers']//tr"));
//        int rowCount = companyList.size();
//
//        for(int i=2; i<=rowCount; i++){
//            String actual_xpath = comp_before_xpath + i + comp_after_xpath;
//            WebElement ele = driver.findElement(By.xpath(actual_xpath));
//            String colValue = ele.getText();
//            System.out.println(colValue);
//        }
    }

    /**
     *
     * @param beforeXpath
     * @param afterXpath
     * @return
     * This function will return column values in the form of Array List
     */
    public static ArrayList<String> getColumnData(String beforeXpath, String afterXpath) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> companyList = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        int rowCount = companyList.size();

        for (int i = 2; i <= rowCount; i++) {
            String actual_xpath = beforeXpath + i + afterXpath;
            WebElement ele = driver.findElement(By.xpath(actual_xpath));
            String colValue = ele.getText();
            arrayList.add(colValue);
        }
        return arrayList;
    }

    /**
     *
     * @param beforeXpath
     * @param afterXpath
     * @return
     * This function will return column values in the form of Hash Map
     */
    public static HashMap<Integer, String> getColumnDataMap(String beforeXpath, String afterXpath) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        List<WebElement> companyList = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        int rowCount = companyList.size();

        for (int i = 2; i <= rowCount; i++) {
            String actual_xpath = beforeXpath + i + afterXpath;
            WebElement ele = driver.findElement(By.xpath(actual_xpath));
            String colValue = ele.getText();
            map.put(i-1, colValue);
        }
        return map;
    }
}
