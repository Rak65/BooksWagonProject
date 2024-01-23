package com.bookswagon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishList extends LoginPage{
    @FindBy(xpath = "//a[@href='wishlist.aspx']")
    WebElement wishlist;
    public void clickOnYourWishList() {
        wishlist.click();
    }
    public String getCurrentPageUrl(){
        return webDriver.getCurrentUrl();
    }
}
