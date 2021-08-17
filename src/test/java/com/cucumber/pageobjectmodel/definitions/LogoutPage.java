package com.cucumber.pageobjectmodel.definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class LogoutPage {
 
    WebDriver driver;
 
    @FindBy(id = "welcome")
    WebElement welcomelink;
    
    
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutlink;
    
    @FindBy(id = "logInPanelHeading")
    WebElement verifyloginpanel;
    
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
 
        PageFactory.initElements(driver, this);
    }
 
    public void getwelcomelink() {
    	welcomelink.click();
    }
    public void getlogoutlink() {
    	logoutlink.click();
    } 
    
    public String getverifyloginpanel() {
        return verifyloginpanel.getText();
 
    }
   
}