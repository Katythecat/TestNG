package class01.rewatch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGExample {
    //test1
    //go to syntax Hrms
    //enter the username and password, verify that u logged in
    // close the browser
    // make WebDriver instance we can call anywhere

    WebDriver driver;
    @BeforeMethod
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        //set up driver and webDriver manager dependency will take care of it
        //even the version of driver has changed so no worries!!!!!
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @AfterMethod
    public void Close(){
        driver.quit();
    }

    @Test(enabled = false)
    public void loginFunctionality(){
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm12");//put wrong password
        WebElement loginBtn=driver.findElement(By.xpath("//*[@id='btnLogin']"));
       loginBtn.click();
    }

    //testcase 2
    // verify that password text box is displayed on the login page
    @Test
    public void passwordTextBoxVerification(){
        WebElement password=driver.findElement(By.id("txtPassword"));
        System.out.println(password.isDisplayed());
    }
}
