package Testng.Selenium.Demo;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class DataProviderInTestNG {
	public String baseUrl = "https://en-gb.facebook.com/";
    String driverPath = "/Users/kalpe/eclipse-workspace/TestNGSeleniumDemo/Driver/chromedriver.exe";
    public WebDriver driver ;
    
    @Test(priority = 0)
    public void launchBrowser() {
        System.out.println("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Create New')]"));
        element.click();
    }
    
	  @Test(dataProvider = "dp",priority = 1)
	  public void firstName_lastName(String firstName, String lastName, String MobNo) {
		  driver.findElement(By.name("firstname")).clear();
		  driver.findElement(By.name("firstname")).sendKeys(firstName);
		  System.out.println("fname Executed");
		  driver.findElement(By.name("lastname")).clear();
		  driver.findElement(By.name("lastname")).sendKeys(lastName);
		  System.out.println("lname Executed");
		  driver.findElement(By.name("reg_email__")).clear();
		  driver.findElement(By.name("reg_email__")).sendKeys(MobNo);
		  System.out.println("MobNo Executed");
		  }
	  
	  @Test(dataProvider = "dp",priority = 2)
	  public void mobNo_password(String MobNo, String pass) {
		  driver.findElement(By.name("reg_email__")).clear();
		  driver.findElement(By.name("reg_email__")).sendKeys(MobNo);
		  System.out.println("MobNo Executed");
		  driver.findElement(By.name("reg_passwd__")).clear();
		  driver.findElement(By.name("reg_passwd__")).sendKeys(pass);
		  System.out.println("pass Executed");
		  }
	
	  //If the SAME DataProvider should behave differently with different test method , use Method parameter.
	  @DataProvider
	  public Object[][] dp(Method m) {
		  if (m.getName().equalsIgnoreCase("firstName_lastName")) {
		  return new Object[][]{
			                  {"Ajay","Dhal","asdffffff"},{"Vijay","dole","567yggggg"},{"Sanjay","More","yttghhjjkk"}};}
			                  else {
		return new Object[][]{
				                  {"Ajay60@gmail.com","Abc@!123"},{"Vijay70@gmail.com","Bcd@!456"},{"Sanjay80@gmail.com","Cde@!789"}};}
	  }    
//	    @DataProvider
//		  public Object[][] dp() {
//		    Object[][] data = new Object[3][3];
//		      data[0][0] ="ajay"; 
//		      data[0][1] = "dhal";
//		      data[1][0] ="vijay"; 
//		      data[1][1] = "dole";
//		      data[2][0] ="sanjay"; 
//		      data[2][1] = "abchh";
//		      return data;
//	    };
	  }