package Testng.Selenium.Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemoFacebook {
	
	public String baseUrl = "https://en-gb.facebook.com/";
    String driverPath = "/Users/kalpe/eclipse-workspace/TestNGSeleniumDemo/Driver/chromedriver.exe";
    public WebDriver driver ;
    
    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Before Test Executed");
    }
    
    @BeforeClass
    public void verifyURL() {
    	String expectedURL = "Facebook – log in or sign up";
        String actualURL = driver.getTitle();
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("Before Class Executed");
    }
    
    @AfterClass
    public void verifyURL1() {
    	String expectedURL = "Facebook – log in or sign up";
        String actualURL = driver.getTitle();
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("After Class Executed");
    }
     
  @BeforeMethod
  public void verifyHomepageTitle() {
      String expectedTitle = "Facebook – log in or sign up";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      System.out.println("Before Method Executed");
  }
  
  @AfterMethod
  public void verifyHomepageTitle1() {
      String expectedTitle = "Facebook – log in or sign up";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      System.out.println("After Method Executed\n");
  }
  
  @Test(priority = 0)
  public void verifyCreateNewAccountField() {
      WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Create New')]"));
      element.click();
      Assert.assertEquals(driver.getCurrentUrl(), "https://en-gb.facebook.com/");
      System.out.println("First Test Executed");
  }
  
  @Test(priority = 1)
  public void verifyFirstNameField() {
	  driver.findElement(By.name("firstname")).sendKeys("Kalpesh");
	  System.out.println("Second Test Executed");
  }
  
  @Test(priority = 2)
  public void verifyLastNameField() {
	  driver.findElement(By.name("lastname")).sendKeys("Dhalpe");
	  System.out.println("Third Test Executed");
  }
  
  @Test(dependsOnMethods = "verifyPasswordField")
  public void verifyMobileNoField() {
	  driver.findElement(By.name("reg_email__")).sendKeys("7878786543");
	  System.out.println("Fourth Test Executed");
  }
  
  @Test(priority = 4)
  public void verifyPasswordField() {
	  driver.findElement(By.name("reg_passwd__")).sendKeys("Ajyu&1800");
	  System.out.println("Fifth Test Executed");
  }
  
  @Test(priority = 5)
  public void verifyDOBField() {
	  driver.findElement(By.name("birthday_day")).sendKeys("07");
      driver.findElement(By.name("birthday_month")).sendKeys("June");
      driver.findElement(By.name("birthday_year")).sendKeys("1998");
      System.out.println("Sixth Test Executed");
  }
  
  @Test(priority = 6)
  public void verifyGenderField() {
	  driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
      driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
      driver.findElement(By.xpath("//label[contains(text(),'Custom')]"));
      System.out.println("Seventh Test Executed");
  }
  
  @Test(priority = 7)
  public void logIn() {
	  driver.findElement(By.name("websubmit")).click();
	  System.out.println("Eight Test Executed");
  }
  
  @AfterTest
  public void terminateBrowser(){
      driver.close();
      System.out.println("After Test Executed");
  }
}
