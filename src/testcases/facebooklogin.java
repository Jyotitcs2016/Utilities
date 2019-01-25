package testcases;

import javax.xml.bind.ParseConversionEvent;


import org.openqa.selenium.By;

import Utilities.ApachePOI;
import assignments.baseclass.base_class;

public class facebooklogin extends base_class {

	
	public static ApachePOI excel;

public static void main(String[] args) throws Exception  {
	startbrowser();
	excel=new ApachePOI();
	String[] cred= {config.getProperty("id"),config.getProperty("password")};
	driver.get("https://en-gb.facebook.com/login/");
	
	driver.findElement(By.cssSelector("input[id='email']")).sendKeys(excel.getstringData("Sheet1",0 ,0));
	System.out.println(excel.getstringData("Sheet1",0 ,0));
	driver.findElement(By.cssSelector("input[id='pass']")).sendKeys(excel.getstringData("Sheet1",0 ,1));
	System.out.println(excel.getstringData("Sheet1",0 ,1));
	driver.findElement(By.cssSelector("body[dir='ltr']")).click();
	System.out.println("Hello World!!");

	driver.close();


}

}
