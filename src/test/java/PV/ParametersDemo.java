package PV;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ParametersDemo {

    WebDriver driver;
    @BeforeClass
    @Parameters({"browser", "url"})
    void setup(String browser,String url) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup(); // set up chrome driver
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get(url);
    }

    @Test(priority = 1)
    void logoTest(){
        WebElement logo=driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"));
        Assert.assertTrue(logo.isDisplayed(),"Logo is not displayed on the page");
    }

    @Test(priority = 2)
    void homepageTitle(){
        String exp="OrangeHRM";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,exp,"Title is not matched");
    }

    @AfterClass
    void close(){
        driver.quit();
    }

    }

