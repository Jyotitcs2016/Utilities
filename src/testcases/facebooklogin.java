package testcases;

import javax.xml.bind.ParseConversionEvent;

import org.openqa.selenium.By;

import assignments.baseclass.base_class;

public class facebooklogin extends base_class {

public static void main(String[] args) throws Exception {
	startbrowser();
	String[] cred= {config.getProperty("id"),config.getProperty("password")};
	driver.get("https://en-gb.facebook.com/login/");
	
	driver.findElement(By.cssSelector("input[id='email']")).sendKeys(cred[0]);
	System.out.println(cred[0]);
	driver.findElement(By.cssSelector("input[id='pass']")).sendKeys(cred[1]);
	System.out.println(cred[1]);
	driver.findElement(By.cssSelector("body[dir='ltr']")).click();
	System.out.println("Hello World!!");

	driver.close();


}

}
