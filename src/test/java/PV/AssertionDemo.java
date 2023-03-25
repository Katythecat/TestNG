package PV;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionDemo {

    WebDriver driver;
    @BeforeClass
    void setup(){
            WebDriverManager.chromedriver().setup();//set up chrome driver
            driver = new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    @Test
    void logoTest(){
        WebElement logo=driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"));
        Assert.assertTrue(logo.isDisplayed(),"Logo not display on the page");
    }

    @Test
    void homepageTitle(){
        String exp="OrangeHRM";
        String ActualTitle=driver.getTitle();
        Assert.assertEquals(ActualTitle,exp,"Title is not matched");
    }

    @AfterClass
    void close(){
        driver.quit();
    }

    }

