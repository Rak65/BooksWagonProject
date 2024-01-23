package com.bookswagon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyOrders extends HomePage{
    @FindBy(xpath = "//a[@href='orders.aspx']")
    WebElement myOrder;
    public void clickOnMyOrders() {
        myOrder.click();
    }
    public String getCurrentPageUrl(){
        return webDriver.getCurrentUrl();
    }
}
