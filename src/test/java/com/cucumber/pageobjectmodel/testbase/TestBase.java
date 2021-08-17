package com.cucumber.pageobjectmodel.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase  {
	public static WebDriver driver;
	
	public Properties prop;
	String path;

	
public  TestBase() {
		
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("config.properties");
			try {
				prop.load(ip);
				System.out.println("my properties is"+prop);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		
	}
       
	
	
	
	public String getScreenshot() throws IOException
	{
		String timeStamp;
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyy MM dd_HH mm ss").format(Calendar.getInstance().getTime()); 
		File screenShotName = new File("./Screenshot//"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);
		 
		String filePath = screenShotName.toString();
	
		return path;
		
	}
	
	
	public static  WebDriver Launch(String BrowserName) 
	{
		
	 
	 if(BrowserName.equalsIgnoreCase("Chrome") ) {
			
				System.setProperty("webdriver.chrome.driver","./chromedriver_win32//\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			else if(BrowserName.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver","./chromedriver_win32//\\chromedriver.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			else if(BrowserName.equalsIgnoreCase("FireFox")){
				System.setProperty("webdriver.gecko.driver","‪D:\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			return driver;
		
	

}
}
