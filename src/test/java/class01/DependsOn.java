package class01;

import org.testng.annotations.Test;

public class DependsOn {

    @Test
    public void Login(){
        System.out.println("I am here");
    }

    @Test(dependsOnMethods = {"Login"} )
    public void dashBoardVerification(){
        System.out.println("After login I am verifying dashboard");
    }
}
