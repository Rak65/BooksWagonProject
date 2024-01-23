package com.bookswagon.base;

import com.bookswagon.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver webDriver;
    public static Properties properties;
    public BaseClass(){
        try {
            properties =new Properties();
            FileInputStream fileInputStream = new FileInputStream("H:\\CFP251\\BooksWagon\\src\\main\\java\\com\\bookswagon\\configuration\\config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static void initialization(){
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            webDriver = new ChromeDriver(chromeOptions);
        }
        webDriver.get(properties.getProperty("url"));
        webDriver.findElement(By.id("ctl00_lblUser")).click();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
    }
}
