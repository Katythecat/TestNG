package class02.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class SoftAssertDemo {
    //go to syntax hrm
    //send no credentials and click on login button
    //verify the error message is username can not be empty

    WebDriver driver;
    @BeforeMethod
    void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @AfterMethod
    void closeApp(){
        driver.quit();
    }

    @Test
    public void testCase(){
        //click login btn
        WebElement logbtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        logbtn.click();
        WebElement errorMsg=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualError= errorMsg.getText();
        //Declare String to compare the actualError
        String expectedError="Username cannot be empt";
        //use soft assertion to test
        SoftAssert soft=new SoftAssert();
        //compare
        soft.assertEquals(actualError,expectedError);
        //login btn is displayed or not
        boolean loginBtn=logbtn.isDisplayed();
        System.out.println("The state of the display login is "+loginBtn);
        //call sort assert
        soft.assertTrue(loginBtn);

        //last step must do it everytime
        soft.assertAll();

        //soft assert even the first test case fail the other will be executed





    }



}
