package com.bookswagon.datadriventest;

import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.LoginPage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDrivenLoginTest extends BaseClass {
    LoginPage loginPage;
    DataDrivenLoginTest(){
        super();
    }
    @BeforeMethod
    public void setLoginPage(){
        initialization();
        loginPage = new LoginPage();
    }
    @Test(dataProvider="Excel")
    public void loginTest(String mobileNumber, String password) {
        loginPage.login(mobileNumber,password);
    }
    @DataProvider(name = "Excel")
    public Object[][] testDataGenerator() throws IOException {
        FileInputStream file = new FileInputStream("H:\\CFP251\\BooksWagon\\testData\\Testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet loginSheet = workbook.getSheet("Login");
        int numbeOfData = loginSheet.getPhysicalNumberOfRows();
        Object[][] testData = new Object[numbeOfData][2];

        for (int i=0; i< numbeOfData; i++){
            XSSFRow row = loginSheet.getRow(i);
            XSSFCell mobileNumber = row.getCell(0);
            XSSFCell password = row.getCell(1);
            double mobile = mobileNumber.getNumericCellValue();
            String mobileNumberString = String.valueOf((long) mobile);
            String passwordValue = password.getStringCellValue();
            testData[i][0] = mobileNumberString;
            testData[i][1] = passwordValue;
        }
        return testData;
    }
    @AfterMethod
    public void close() {
        webDriver.quit();
    }
}
