package com.bookswagon.testcases;
import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.HomePage;
import com.bookswagon.pages.LoginPage;
import com.bookswagon.pages.WishList;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTest extends BaseClass{
    LoginPage loginPage;
    HomePage homePage;
    WishList wishList;
    public WishListTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        wishList = new WishList();
        loginPage.login(properties.getProperty("mobileNum"), properties.getProperty("password"));
    }
    @Test(priority = 1)
    public void checkMyWishList(){
        wishList.clickOnYourWishList();
    }
    @Test(priority = 2)
    public void verifyMyWishListPageUrl(){
        wishList.clickOnYourWishList();
        String url = wishList.getCurrentPageUrl();
        Assert.assertEquals(url,"https://www.bookswagon.com/wishlist.aspx");
    }
    @AfterMethod
    public void quite() {
        webDriver.quit();
    }
}
