package class02.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {
    //    Test Scenario:
//    navigate to syntax HRMS
//    login into the website using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();//set up chrome driver
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @DataProvider(name = "credentialsMsg")
    public Object[][] data() {
        return new Object[][]{
                {"Admin", "12345", "Invalid credential"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empt"},
                {"", "Hum@nhrm123", "Username cannot be empt"}
        };
    }

        @Test(dataProvider = "credentialsMsg")
        public void invalidCredentialMsg (String userName, String passWord, String errorMsg){
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //get the error msg
            WebElement error= driver.findElement(By.xpath("//span[@id='spanMessage']"));
            String actualErrMsg=error.getText();

            Assert.assertEquals(actualErrMsg,errorMsg);//we use hard assertion bc it is one assertion in single test case
    }




}



