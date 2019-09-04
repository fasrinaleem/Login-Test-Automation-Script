import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestScript {

    WebDriver driver;

    @Test()
    public void webBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testing-ground.scraping.pro/login");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


    @Test(priority = 1)
    public void login(){
        WebElement userName = driver.findElement(By.id("usr"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.xpath("//*[@id='case_login']/form/input[3]"));

        userName.sendKeys("admin");
        password.sendKeys("12345");
        submit.click();
    }
}
