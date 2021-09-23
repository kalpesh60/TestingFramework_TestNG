package Testng.Selenium.Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EbayTestNG {
  
    String driverPath = "/Users/kalpe/eclipse-workspace/TestNGSeleniumDemo/Driver/chromedriver.exe";
    public WebDriver driver ;
    
    @BeforeTest
	public void init() {
    	System.setProperty("webdriver.chrome.driver", driverPath);
    	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.navigate().to("https://www.ebay.com/");
	}
    
    @Test
	public void searchProduct() {
    	WebElement element = driver.findElement(By.linkText("Electronics"));
    	Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Apple")).click();
		driver.findElement(By.linkText("iPhone 11")).click();
	}
    
    @Test
	public void selectProduct() {
		driver.findElement(By.xpath("//h3[contains(text(),'Apple iPhone 11 - 128GB - White (Unlocked) A2111 (CDMA + GSM)')]")).click();
		driver.findElement(By.linkText("Add to cart")).click();
    }
    
    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
