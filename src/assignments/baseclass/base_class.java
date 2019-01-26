package assignments.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utilities.ApachePOI;
import Utilities.MailAttachment;



public class base_class {
	public static ApachePOI excel;
	public static WebDriver driver;
	public static FileInputStream fis;
	
	public static Properties config=new Properties();
	
	public static void store(String id,String pass) {
		id=config.getProperty("id");
		pass=config.getProperty("password");
		
	}
	
	public static void mousehover(String hoverobject) {
		Actions action = new Actions(driver);
		
		WebElement object=driver.findElement(By.xpath(hoverobject));
		action.moveToElement(object).build().perform();
		
	}
	
	
	public static  void startbrowser() throws Exception {
		String id=config.getProperty("id");
		
		String pass=config.getProperty("password");
		fis=new FileInputStream(System.getProperty("user.dir")+"\\properties\\id_passcode.properties");
		config.load(fis);
		if(config.getProperty("browser").equals("ie")) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\library\\IEDriverServer.exe");
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		driver=(WebDriver) new InternetExplorerDriver(capabilities);
	   driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		if(config.getProperty("browser").equals("chrome")) {
			
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\library\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
		}
	}
	
	
	
	

}
