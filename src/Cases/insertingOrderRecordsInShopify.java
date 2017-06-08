package Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class insertingOrderRecordsInShopify {
	WebDriver driver;

	@BeforeMethod
	public void start() {
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jar\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Jar\\geckodriver-v0.11.1-win32\\geckodriver.exe");
		driver = new FirefoxDriver();

	}

	@Test
	public void TC_001() throws InterruptedException{

		try{
			driver.get("https://testing2-103.myshopify.com/admin");
			driver.findElement(By.xpath("//input[@name='login']")).sendKeys("rajesh.kumar@arcscorp.net");
			driver.findElement(By.id("password")).sendKeys("abcd@1234");
			driver.findElement(By.name("commit")).click();
			//Thread.sleep(7000);
			WebDriverWait wait10= new WebDriverWait(driver, 100);
			wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Orders')]")));

			for(int i=386; i<=1000;i++)
			{
				driver.findElement(By.xpath("//span[contains(.,'Orders')]")).click();
				WebDriverWait wait3= new WebDriverWait(driver, 100);
				wait3.until(ExpectedConditions.elementToBeClickable(By.linkText("Create order")));
				driver.findElement(By.linkText("Create order")).click();
				WebDriverWait wait1= new WebDriverWait(driver, 100);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@autofocus='autofocus']")));
				driver.findElement(By.xpath("//input[@autofocus='autofocus']")).sendKeys("ip");
				Thread.sleep(2000);
				WebDriverWait wait6= new WebDriverWait(driver, 100);
				wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product_picker_modal']/div[3]/div/ul/li[1]/a")));
				driver.findElement(By.xpath("//*[@id='product_picker_modal']/div[3]/div/ul/li[1]/a")).click();
				WebDriverWait wait2= new WebDriverWait(driver, 100);
				wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-bind-event-click='productSelectionCache.toggleProduct(10005484170)']")));
				driver.findElement(By.xpath("//div[@data-bind-event-click='productSelectionCache.toggleProduct(10005484170)']")).click();;
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@id='add-products']")).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//input[@id='customer_search_input']")).sendKeys("aditya");
				WebDriverWait wait4= new WebDriverWait(driver, 100);
				wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@bind-event-click='selectSuggestion(5967439562, event)']")));
				driver.findElement(By.xpath("//button[@bind-event-click='selectSuggestion(5967439562, event)']")).click();
				WebDriverWait wait5= new WebDriverWait(driver, 100);
				wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='markAsPaidModalBtn']")));
				driver.findElement(By.xpath("//*[@id='markAsPaidModalBtn']")).click();
				WebDriverWait wait= new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary js-btn-loadable has-loading']")));
				driver.findElement(By.xpath("//button[@class='btn btn-primary js-btn-loadable has-loading']")).click();
				driver.get("https://testing2-103.myshopify.com/admin");
				System.out.println("Order Created: "+i);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}


}
