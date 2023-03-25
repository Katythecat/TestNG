package PV;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    @DataProvider(name="LoginData")
    public Object[][] getData(){
        Object[][] data={{"abc@gmail.com","abc"},{"xyz@gamil.com","xyz"},{"ato@gmail.com","jfoe"}};
        return data;
    }
}
