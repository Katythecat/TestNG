package class01;

import org.testng.annotations.Test;

public class DependsOn {
    //use for refer to the case if that case is failed we don't need to test the next case


    @Test
    public void Login(){
       // System.out.println(10/0);
        System.out.println("I am here");
    }

    @Test(dependsOnMethods = {"Login"} )
    public void dashBoardVerification(){
        System.out.println("After login I am verifying dashboard");
    }
}
