import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestScript {

    WebDriver driver;

    @Test(priority = 0)
    public void webBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testing-ground.scraping.pro/login");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.HOURS);
    }

    @Test(priority = 1)
    public void login(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MINUTES);

        WebElement userName = driver.findElement(By.id("usr"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.xpath("//*[@id='case_login']/form/input[3]"));

        userName.sendKeys("admin");
        password.sendKeys("123455");
        submit.click();
//        WebDriverWait wait = new WebDriverWait(driver,60);
//        wait.until(ExpectedConditions.visibilityOf(userName));
//        wait.until(ExpectedConditions.visibilityOf(password));
    }
//
    @Test(priority = 2)
    public void loginStatus(){

        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Scraper Testing Ground";
        Assert.assertEquals(expectedTitle,actualTitle);

        if(actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
    }
}
