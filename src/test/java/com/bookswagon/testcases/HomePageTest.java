package com.bookswagon.testcases;
import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.HomePage;
import com.bookswagon.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass{
    LoginPage loginPage;
    HomePage homePage;
    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        loginPage.login(properties.getProperty("mobileNum"), properties.getProperty("password"));
        homePage = new HomePage();
    }
    @Test
    public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
//        System.out.println("Title"+homePageTitle);
        Assert.assertEquals(homePageTitle,"Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
    }
    @AfterTest
    public void close(){
        webDriver.quit();
    }
}
