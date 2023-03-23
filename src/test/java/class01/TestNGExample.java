package class01;

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


    WebDriver driver ; // we can use either or
    //public static WebDriver driver;
    //pre-condition -->to open the window
    //              -->to set implicit wait
    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //Thread.sleep(2000);  we can put slow this line but not recommended
       driver.quit();
    }

    //test case 1
    //verify login functionality
    @Test(groups = "regression")
    public void loginFunctionality(){
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginBtn=driver.findElement(By.xpath("//*[@id='btnLogin']"));
        loginBtn.click();
    }

    //testcase 2
    // verify that password text box is displayed on the login page

    @Test
    public void passwordTextBoxVerification(){
        //find the web element password text box
        WebElement password=driver.findElement(By.id("txtPassword"));
        System.out.println(password.isDisplayed());
    }
}
