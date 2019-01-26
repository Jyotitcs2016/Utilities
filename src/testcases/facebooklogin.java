package testcases;

import javax.xml.bind.ParseConversionEvent;


import org.openqa.selenium.By;

import Utilities.ApachePOI;
import Utilities.MailAttachment;
import Utilities.testmail;
import assignments.baseclass.base_class;

public class facebooklogin extends base_class {


	public static  testmail mail;
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
	System.out.println("Mail started sending");
	

	mail.SendMAil("MailPoling/exception.txt", "Test email", "Jyoti", "jyotiprakash569@gmail.com", "Test email", "Mail sent");
	
	System.out.println("Mail sent");
	driver.close();


}

}
