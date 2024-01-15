package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataReader {

    public static void main(String[] args) {
        String fileName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\csvFiles\\testData.csv";
        readDataFromCSV(fileName);
        // getMapsFrom(fileName);
    }

    public static List<Map<String, String>> readDataFromCSV(String fileName) {
        List<Map<String, String>> maps = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String data;
            String[] header = null;
            while ((data = bufferedReader.readLine()) != null) {
                if (header == null) {
                    header = data.split(",");
                } else {
                    String[] colValues = data.split(",");
                    Map<String, String> testData = new HashMap<>();
                    for (int count = 0; count < header.length; count++) {
                        testData.put(header[count], colValues[count]);
                    }
                    maps.add(testData);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maps;
    }
}
