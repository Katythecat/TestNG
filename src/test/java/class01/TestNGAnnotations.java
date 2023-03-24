package class01;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeClass // BeforeClass and AfterClass will execute one before and after class
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @AfterMethod // BeforeMethod and AfterMethod will execute before and after in every test cases
    public void afterMethod(){
        System.out.println("I am after method");
    }


    @Test(groups = "regression")
    public void aFirstTestCase(){
        System.out.println("I am the first test case");
    }

    @Test
    public void mySecondTestCase(){
        System.out.println("I want food");
    }

    @Test
    public void myThirdTestCase(){
        System.out.println("TestNg is fun");
    }



}
