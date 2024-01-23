package com.bookswagon.testcases;
import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    public LoginPageTest(){
        super();
    }
    @BeforeMethod
    public void setLoginPage(){
        initialization();
        loginPage = new LoginPage();
    }
    @Test(priority =1)
    public void validateLoginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,
                "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
    }
    @Test(priority = 2)
    public void loginTest(){
        loginPage.login(properties.getProperty("mobileNum"), properties.getProperty("password"));
    }
    @AfterTest
    public void close(){
        webDriver.quit();
    }
}
