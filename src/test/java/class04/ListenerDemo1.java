package class04;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo1 implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("The test case has passed "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The test case has failed "+result.getName());
        //TakesScreenshot takesScreenshot=(TakesScreenshot)
        //if we want to take screen shot when it failed write it down here
    }
}
