package automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FramesAndAction {
	
	
	
	public String baseUrl ="http://demo.guru99.com/test/guru99home/";
    public WebDriver driver;
	public String driverPath = "C:\\Users\\Tharshini\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	
	
   @BeforeTest
   public void setUp() {
	   
	   System.setProperty("webdriver.chrome.driver",driverPath );
	   driver =new ChromeDriver();
	   
   }
   
   
	@Test
  public void switchFrame() {
		
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		//String pageUrl = driver.getTitle();	    
		System.out.println("Page Title: " + driver.getCurrentUrl());
		driver.switchTo().frame("a077aa5e");
		String frameTitle = driver.getCurrentUrl();
		
		System.out.println("FrameTile: "+driver.getCurrentUrl());
		Assert.assertEquals(frameTitle, "http://demo.guru99.com/test/guru99home/");
		
		driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
	
		
		//System.out.println("****"+frameTitle);
		
		
		
  }
	
 @Test
 public void switingTabs() {
	 ArrayList <String> tabs =new ArrayList<String>( driver.getWindowHandles());
		
	    driver.switchTo().window(tabs.get(1));
	    System.out.println("2nd tab Url : " + driver.getCurrentUrl());
	    
	 
 }
}
