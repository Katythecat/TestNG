package PV;

import org.testng.annotations.Test;

public class GroupingDemo {

    @Test(groups="sanity")
    void test1(){
        System.out.println("This is test 1");
    }

    @Test(groups="sanity")
    void test2(){
        System.out.println("This is test 2");
    }

    @Test(groups = "regression")
    void test3(){
        System.out.println("This is test 3");
    }

    @Test(groups = "regression")
    void test4(){
        System.out.println("This is test 4");
    }

    @Test(groups = {"sanity","regression"})
    void test5(){
        System.out.println("This is test 5");
    }
}
