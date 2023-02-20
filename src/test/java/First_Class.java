import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


import java.awt.*;
import java.util.ArrayList;

public class First_Class {

    //    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        // Setup Chrome driver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");///path/to/
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().window().maximize();

        WebElement acceptBtn = driver.findElement(By.id("L2AGLb"));
        acceptBtn.click();

        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Dex trade");

        Thread.sleep(2000);
        WebElement searchBtn = driver.findElement(By.name("btnK"));
//        searchBtn.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",  searchBtn);

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.google.com/', '_blank');");
        driver.switchTo().window(newTab.get(1));






//        driver.quit();

//        WebDriverManager.chromedriver().setup();
    }
}
