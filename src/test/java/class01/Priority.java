package class01;


import org.testng.annotations.Test;

public class Priority {

    @Test//(priority = 3)
    public void dTest(){
        System.out.println("I am TestA");
    }
    @Test//(priority = 1)
    public void bTest(){
        System.out.println("I am TestB");
    }

    @Test//(priority = 2)
    public void cTest(){
        System.out.println("I am TestC");
    }



}
