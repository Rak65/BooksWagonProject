package com.bookswagon.pages;

public class HomePage extends LoginPage{
    public String verifyHomePageTitle(){
        return webDriver.getTitle();
    }
}
