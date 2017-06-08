package Cases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBrokenImages {
	WebDriver fd;
	private int invalidImageCount;
	String ChromeDriverPath= "D:\\Mars\\AFAS\\Drivers\\chromedriver.exe";
	
	@BeforeMethod
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		fd=new ChromeDriver();
		
	}
	
	//Code to find the broken images on web page.
	
	@Test
	
	public void TC_002() throws InterruptedException
	{
		//fd.get("http://monsterville.arcsqc.com/");
		fd.get("http://info.alliedfireandsecurity.com/topic/fire-alarms-portland");
		Thread.sleep(5000);
		//fd.get("file:///C:/Users/namanagrawal/Desktop/test.html");
		try
		{
			List<WebElement> no = fd.findElements(By.tagName("img"));
			int nooflinks = no.size();
			System.out.println("Total Images: " + nooflinks);
			for (WebElement pagelink : no)
			{
				String linktext = pagelink.getAttribute("alt");
				String link = pagelink.getAttribute("src");
				URL u = new URL(link);
				HttpURLConnection h = (HttpURLConnection) u.openConnection();
				h.setRequestMethod("GET");
				h.connect();
				int responsecode = h.getResponseCode();
				System.out.println(linktext+"\t" + link + "\t" + "Response Code: " + responsecode);
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	
	@AfterMethod
	public void quit()
	{
		fd.quit();
	}

}
