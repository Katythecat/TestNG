package class01;

import org.testng.annotations.Test;

public class EnableDisable {

    @Test(enabled = false)//instead of comment it we can make it default after report
    //bug to dev
    public void aTest(){
        System.out.println("I am first test case");
    }

    @Test
    public void bTest(){
        System.out.println("I am the second test case");
    }

    @Test(enabled = false)
    public void cTest(){
        System.out.println("I am the third test case");
    }


}
