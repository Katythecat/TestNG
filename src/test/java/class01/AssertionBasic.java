package class01;

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

    public static WebDriver driver ;

    @BeforeMethod
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser(){
        //Thread.sleep(2000);  we can put slow this line but not recommended
        driver.quit();
    }

    //testcase
    //enter the username : Admin
    //enter the password : jfoeoijr
    //click on login button
    //verify that the message invalid credentials is displayed
    //verify that password text box is displayed

    @Test
    public void invalidCredentials(){
     // locate the web element username and send keys
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
     // locate the web element password and send keys
        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("fhefds;jk");
     //locate login button and click login
        WebElement loginBtn=driver.findElement(By.xpath("//*[@id='btnLogin']"));
        loginBtn.click();
        //verify the error message
        WebElement error= driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String err= error.getText();
        //check if the error message is correct
        String expectedError="Invalid credentials";
        //assert the value
        Assert.assertEquals(expectedError,err);//this only for testNG

        //finding the password again as it is discarded when we clicked on login button
        //bc the DOM is refreshed
        //password text box is displayed
        password=driver.findElement(By.id("txtPassword"));
        boolean pswrdDisplayed=password.isDisplayed();
        //verify that the text box is displayed
        Assert.assertTrue(pswrdDisplayed);
    }
}


