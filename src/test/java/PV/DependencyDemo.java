package PV;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyDemo {

    @Test
    void startCar(){
        System.out.println("Car started");
        Assert.fail();
    }

    @Test(dependsOnMethods = "startCar")
    void driveCar(){
        System.out.println("Car driving");
    }

    @Test(dependsOnMethods = "driveCar")
    void stopCar(){
        System.out.println("Car stopped");
    }

    @Test(dependsOnMethods = {"driveCar","stopCar"},alwaysRun = true)
    void parkCar(){
        System.out.println("Car parked");
    }
}
