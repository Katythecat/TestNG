package PV;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelTest1 {

    WebDriver driver;
    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();//set up chrome driver
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    void logoTest() throws InterruptedException {
        WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"));
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(5000);

    }
    @Test
    void homePageTitle() throws InterruptedException {
        String exp="OrangeHRM";
        String ActualTitle=driver.getTitle();
        Assert.assertEquals(ActualTitle,exp,"Title is not matched");
        Thread.sleep(5000);

    }
    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
