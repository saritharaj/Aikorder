package org.com.aik.airkorder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
public static WebDriver driver;
	
public static void OpenBrowser() {
	
	System.setProperty("webdriver.chrome.driver","D:\\Automation\\airkorder\\Driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://dev-olens.aik-order.com/");
	driver.manage().window().maximize(); 
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
	
}

}
