package class01.rewatch;

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

public class AssertionBasic {

    WebDriver driver;
    //precondition
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
    //post condition
    @AfterMethod
    public void Close(){
        driver.quit();
    }

    //test case 1
    //enter the username:Admin
    //enter the password:dkjferjf
    //click login button
    //verify that the message invalid credentials is displayed

    @Test
    public void invalidCredentials(){
        //locate the web element username and send keys
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        //locate the web element password and send keys
        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("fiijdgiej");
        //locate the login button and click login
        WebElement loginBtn=driver.findElement(By.xpath("//*[@id='btnLogin']"));
        loginBtn.click();

        //verify error message
        WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errMsg= error.getText();
        //check if the error message is correct
        String expErrMsg="Invalid credential";

        //assert the value
        Assert.assertEquals(errMsg,expErrMsg);


        //we won't get the right result by using if else
        /*if(errMsg.equalsIgnoreCase(expErrMsg)){
            System.out.println("Test case is passed");
        }else{
            System.out.println("Test case is failed");
        }*/

        //password text box is displayed
        //bc we got stale error bc the page is refreshed and is discarded do we need to find element again
        password=driver.findElement(By.id("txtPassword"));
        boolean pswDisplayted=password.isDisplayed();
        //verify that the text box is displayed
        Assert.assertTrue(pswDisplayted);




    }
}
