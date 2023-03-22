package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }


    @Test
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
