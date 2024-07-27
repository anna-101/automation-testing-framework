package com.testing.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        System.out.println("Root"+ " "+System.getProperty("user.dir"));
        Properties config = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
        config.load(file);
        System.out.println(config.getProperty("browser"));
    }
}
