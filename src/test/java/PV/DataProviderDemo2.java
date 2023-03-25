package PV;

import org.testng.annotations.Test;

public class DataProviderDemo2 {

    @Test(dataProvider = "LoginData" , dataProviderClass = CustomDataProvider.class)
    public void loginTest(String email,String pwd){
        System.out.println(email+" "+pwd);
    }

}
