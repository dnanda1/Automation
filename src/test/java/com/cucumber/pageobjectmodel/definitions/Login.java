package com.cucumber.pageobjectmodel.definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class Login {
 
   
 
    WebDriver driver;
 
    @FindBy(name = "txtUsername")
    WebElement userName;
 
    @FindBy(name = "txtPassword")
    WebElement password;
 
    @FindBy(id = "logInPanelHeading")
    WebElement titleText;
 
    @FindBy(id = "btnLogin")
    WebElement login;
    
    @FindBy(id = "spanMessage")
    WebElement invalidcredentials;
    
   
    
    public Login(WebDriver driver) {
 
        this.driver = driver;
 
        PageFactory.initElements(driver, this);
    }
 
    public void setUserName(String strUserName) {
        userName.sendKeys(strUserName);
    }
 
    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }
 
    public void clickLogin() {
        login.click();
    }
 
    public String getinvalidcredentials() {
        return invalidcredentials.getText();
    }
    
    public String getLoginTitle() {
        return titleText.getText();
    }
 
    public void login(String strUserName, String strPassword) {
 
        this.setUserName(strUserName);
 
        this.setPassword(strPassword);
 
        this.clickLogin();
 
    }
}