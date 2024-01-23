package com.bookswagon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bookswagon.base.BaseClass;
public class LoginPage extends BaseClass{
    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    WebElement mobileNum;
    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    WebElement pass;
    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    WebElement loginBtn;
    public LoginPage(){
        PageFactory.initElements(webDriver,this);
    }
    public String validateLoginPageTitle(){
        return webDriver.getTitle();
    }
    public void login(String mobileNo, String password){
        mobileNum.sendKeys(mobileNo);
        pass.sendKeys(password);
        loginBtn.click();
    }
}
