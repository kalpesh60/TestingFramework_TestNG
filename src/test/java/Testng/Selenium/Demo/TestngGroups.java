package Testng.Selenium.Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestngGroups {
	public String baseUrl = "https://en-gb.facebook.com/";
    String driverPath = "/Users/kalpe/eclipse-workspace/TestNGSeleniumDemo/Driver/chromedriver.exe";
    public WebDriver driver ;
    
    @BeforeGroups(groups = { "group1", "group2","group3" })
    public void beforeGroup() {
    System.out.println("before group Executed");
    }
    
    @AfterGroups(groups = { "group1", "group2" })
    public void afterGroup() {
    System.out.println("after group Executed");
    }
    
    @Test(groups = { "group1", "group2" },priority = 0)
    public void launchBrowser() {
        System.out.println("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("G1 G2 Executed");
    }
  
  @Test(groups = { "group1", "group2" },priority = 1)
  public void verifyCreateNewAccountField() {
      WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Create New')]"));
      element.click();
      Assert.assertEquals(driver.getCurrentUrl(), "https://en-gb.facebook.com/");
      System.out.println("G1 G2 Executed");
  }
  
  @Test(groups = { "group1" },priority = 2)
  public void verifyFirstNameField() {
	  driver.findElement(By.name("firstname")).sendKeys("Kalpesh");
	  System.out.println("G1 Executed");
  }
  
  @Test(groups = { "group2" },priority = 3)
  public void verifyLastNameField() {
	  driver.findElement(By.name("lastname")).sendKeys("Dhalpe");
	  System.out.println("G2 Executed");
  }
  
  @Test(groups = { "group1" },priority = 4)
  public void verifyMobileNoField() {
	  driver.findElement(By.name("reg_email__")).sendKeys("7878786543");
	  System.out.println("G1 Executed");
  }
  
  @Test(groups = { "group2" },priority = 5)
  public void verifyPasswordField() {
	  driver.findElement(By.name("reg_passwd__")).sendKeys("Ajyu&1800");
	  System.out.println("G2 Executed");
  }
  
  @Test(groups = { "group1" },priority = 6)
  public void verifyDOBField() {
	  driver.findElement(By.name("birthday_day")).sendKeys("07");
      driver.findElement(By.name("birthday_month")).sendKeys("June");
      driver.findElement(By.name("birthday_year")).sendKeys("1998");
      System.out.println("G1 Executed");
  }
  
  @Test(groups = { "group2" },priority = 7)
  public void verifyGenderField() {
	  driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
      driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
      driver.findElement(By.xpath("//label[contains(text(),'Custom')]"));
      System.out.println("G2 Executed");
  }
  
  @Test(groups = { "group3" },priority = 8)
  public void logIn() {
	  driver.findElement(By.name("websubmit")).click();
	  System.out.println("G3 Executed");
  }
  
  @Test(groups = { "group1", "group2" },priority = 9)
  public void terminateBrowser(){
      driver.close();
      System.out.println("G1 G2 Executed");
  }
  }
