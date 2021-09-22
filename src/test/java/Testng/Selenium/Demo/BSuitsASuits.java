package Testng.Selenium.Demo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BSuitsASuits {
	
	@BeforeSuite
    public void beforeSuite() {
    	System.out.println("Before Suite Executed");
    }
    
    @AfterSuite
    public void afterSuite() {
    	System.out.println("After Suite Executed");
    }
    
    @BeforeClass
    public void beforeClass() {
    	System.out.println("Before Suite before class Executed");
    }
    
    @AfterClass
    public void afterClass() {
    	System.out.println("After Suite after class Executed");
    }
    
    @Test(dependsOnMethods = "afterSuite1")
    public void beforeSuite1() {
    	System.out.println("depends on Executed first method");
    }
    
    @Test
    public void afterSuite1() {
    	System.out.println("Second method Executed");
    }
}
