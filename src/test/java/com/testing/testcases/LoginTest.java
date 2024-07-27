package com.testing.testcases;

import com.testing.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginTest extends BaseClass {

    @Test
    public void loginAsBankManager(){

        driver.findElement(By.cssSelector(config.getProperty("bmlBtn_CSS"))).click();
    }
}
