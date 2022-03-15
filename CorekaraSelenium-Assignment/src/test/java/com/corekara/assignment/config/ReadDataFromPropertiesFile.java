package com.corekara.assignment.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
@Author -Ashish Singh
*/
public class ReadDataFromPropertiesFile {

    public static Properties readPropertiesFile() throws IOException {
        String fileName=".\\src\\test\\resources\\Properties\\config.properties";
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
