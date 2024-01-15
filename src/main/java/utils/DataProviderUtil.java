package utils;

import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataProviderUtil {

    @DataProvider(name = "testData1")
    public Iterator<Map<String, String>> testData1() {
        String fileName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\csvFiles\\testData.csv";
        List<Map<String, String>> testData = DataReader.readDataFromCSV(fileName);
        return testData.iterator();
    }
}
