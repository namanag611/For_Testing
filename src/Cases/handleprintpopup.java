package Cases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handleprintpopup {
	WebDriver driver;
	
	@BeforeMethod
	public void start() {
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\AutomationTesting\\Drivers\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

	}
	
	@Test
	public void printpop() throws InterruptedException, AWTException
	{
		/*
		driver.get("file:///C:/Users/namanagrawal/Desktop/print.html");
		driver.findElement(By.id("button1")).click();
		//Thread.sleep(6000);
		 * 
		 */
		driver.get("https://vmskiosk-remote.ezcommunicator.net/Bacon/BarcodeSignIn.aspx");
		driver.findElement(By.xpath("//input[@id='bManualLogin']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("Support@relatrix.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("utexas84");
		driver.findElement(By.xpath("//input[@id='bSignIn']")).click();
		String parentWindow = driver.getWindowHandle();
		
		System.out.println(parentWindow); 
		Thread.sleep(7000);
		
		
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		         //<!--Perform your operation here for new window-->
		         driver.close(); //closing child window
		         driver.switchTo().window(parentWindow); //cntrl to parent window
		          }
		       }
		   driver.findElement(By.xpath("//input[@id='bFinish']")).click();
		
		
		
		
		//driver.close();
		
		//Set<String> handles = driver.getWindowHandles();

        //System.out.println(handles);
		
		/*
		
        System.out.println(handle);
        
        
		
		/*Set<String> handle= driver.getWindowHandles();
		for (String test : handle) {
			 
		    System.out.println("Handle: "+handle);
		    
		}
		
		/*
		Robot rb= new Robot();
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
		*/
	}
	
	@AfterMethod
	public void quit() {
		//driver.close();
	}

}
