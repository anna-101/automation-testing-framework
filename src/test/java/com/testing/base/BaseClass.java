package com.testing.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties config = new Properties();
    //public static Properties env
    FileInputStream fileInputStream;

    @BeforeSuite
    public void setUp() throws FileNotFoundException {
        if (driver == null) {
            try {
                fileInputStream = new FileInputStream(System.getProperty("user.dir") + "");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(config.getProperty("browser").equals("chrome")){
            WebDriverManager.chromedriver().setup();
        }else if(config.getProperty("browser").equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
        }
        driver.get(config.getProperty("testsiteurl"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("wait")),TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        if(driver!=null)
        driver.quit();
    }
}
