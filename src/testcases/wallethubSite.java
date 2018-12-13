package testcases;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import assignments.baseclass.base_class;

public class wallethubSite  extends base_class {

	
	public static void main(String[] args) throws Exception {
		
	startbrowser();
	driver.get("http://wallethub.com/profile/test_insurance_company/");
	
	mousehover(config.getProperty("hoverstar"));
		
	mousehover(config.getProperty("hoverstar5"));
        
    	
   //Hover over 4-5 star and click 	
     List<WebElement> ele=driver.findElements(By.xpath(config.getProperty("hoverelements")));
	 int totalstar=ele.size();
	 for(int i=0;i < totalstar;i++) {
	
		WebElement element=ele.get(i);
		String text=element.getAttribute("innerHTML");
	
		if(text.equalsIgnoreCase(config.getProperty("star"))) {
			element.click();
			break;
		}
		
	 }
//Select dropdown Life	 
driver.findElement(By.xpath(config.getProperty("dropdown"))).click();
WebElement Life=driver.findElement(By.cssSelector(config.getProperty("lifeselect")));
Actions action=new Actions(driver);
action.moveToElement(Life).doubleClick().build().perform();
Thread.sleep(2000);
//click overall rating
WebElement star=driver.findElement(By.xpath("//*[@id=\"overallRating\"]/a[5]"));
action.moveToElement(star).build().perform();
star.click();
Thread.sleep(2000);
//enter textbox
String a=config.getProperty("review");
driver.findElement(By.xpath("//*[@id=\"review-content\"]")).sendKeys(a);

//clcik on submit
driver.findElement(By.cssSelector("div[class='submit']")).submit();

driver.navigate().to(config.getProperty("reviewsite"));
WebElement reviewvisible=driver.findElement(By.xpath(config.getProperty("reviewtexts")));


Assert.assertTrue(reviewvisible.getAttribute("innerHTML").contains("Be safe and don’t include personal info."));

	driver.close();
	}

	}

	


