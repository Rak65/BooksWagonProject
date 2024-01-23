package com.bookswagon.testcases;
import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.HomePage;
import com.bookswagon.pages.LoginPage;
import com.bookswagon.pages.MyOrders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyOrdersTest extends BaseClass{
    LoginPage loginPage;
    HomePage homePage;
    MyOrders myOrders;
    public MyOrdersTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        myOrders = new MyOrders();
        loginPage.login(properties.getProperty("mobileNum"), properties.getProperty("password"));
    }
    @Test(priority = 1)
    public void checkMyOrders(){
        myOrders.clickOnMyOrders();
    }
    @Test(priority = 2)
    public void verifyMyOrdersPageUrl(){
        myOrders.clickOnMyOrders();
        String url = myOrders.getCurrentPageUrl();
        Assert.assertEquals(url,"https://www.bookswagon.com/orders.aspx");
    }
    @AfterMethod
    public void close() {
        webDriver.quit();
    }
}
