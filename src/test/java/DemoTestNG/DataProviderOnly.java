package DemoTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderOnly {

    @DataProvider(name = "input-provider")
    public static Object[][] inputData() {
        Object[][] data = new Object[3][3];
        data[0][0] = "James Lee";
        data[0][1] = "James@gmail.com";
        data[0][2] = 1;
        data[1][0] = "Jane Lee";
        data[1][1] = "Jane@gmail.com";
        data[1][2] = 1;
        data[2][0] = "John Lee";
        data[2][1] = "John@gmail.com";
        data[2][2] = 1;

        return data;
    }

}
