package Cases;

import org.testng.annotations.Test;

public class swithcing_between_tabs {

	String URL = "https://nucento.arcsdev.com/admin/login.aspx";
	
	@Test
	public void tabs() throws InterruptedException {
		/*System.setProperty("webdriver.gecko.driver", "D:\\Mars\\Nucento_X2\\Browsers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		/*driver.get(URL);
		String oldTab = driver.getWindowHandle();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='lblForgotPassword']")).sendKeys(selectLinkOpeninNewTab);
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();
		driver.switchTo().window(oldTab);
		driver.findElement(By.xpath("//*[starts-with(@href,'lost')]")).click();
		*/
		
		/*
		driver.get("https://www.google.com");
		Thread.sleep(2000);

		// open the second tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		driver.get("https://www.google.com");
		Thread.sleep(2000);

		// switch to the previous tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "" + Keys.SHIFT + "" + Keys.TAB);
		Thread.sleep(2000);
		*/
		/*
		driver.get(URL);
		WebElement elemLink = driver.findElement(By.xpath("//*[@id='lblForgotPassword']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elemLink);
		actions.contextClick(elemLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		*/
		
	}
	

}
