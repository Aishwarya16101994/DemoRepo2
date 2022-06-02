package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPractice1 {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\sbuddhe_aditya\\Desktop\\QA AUTOMATON\\SeleniumJars\\geckodriver.exe");
		//classname objName = new Classname();
		driver = new FirefoxDriver();
		jse = (JavascriptExecutor)driver;
		driver.get("https://e.centennialcollege.ca/d2l/login?noredirect=1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @Test(priority =1)
  public void incorrectusernameandpassword() throws InterruptedException {
	  
	 	
	  driver.findElement(By.id("userName")).sendKeys("ash%%12dsjbdsm");
	  driver.findElement(By.id("password")).sendKeys("pradhandsbdsaba");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@type = 'button']")).click();
		
		Thread.sleep(3000);
		
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		
		al.dismiss();

	  Thread.sleep(4000);
	 String expectedErr = "Login failed. Try again.";
	  String actualErr = driver.findElement(By.xpath("//p[contains(text(),'Login failed. Try again.')]")).getText();
	  System.out.println(actualErr);
	  Assert.assertEquals(expectedErr, actualErr);
	  
  }

  @Test(priority =2)
  public void nousernameandincorrectpassword() throws InterruptedException {
	  
	 	
	  driver.findElement(By.id("userName")).sendKeys("");
	  driver.findElement(By.id("password")).sendKeys("pradhandsbdsaba");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@type = 'button']")).click();
		
		
		
		/*Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		
		al.dismiss();*/

	  Thread.sleep(4000);
	 String expectedErr = "Username is required.";
	  String actualErr = driver.findElement(By.className("d2l-link")).getText();
	  System.out.println(actualErr);
	  Assert.assertEquals(expectedErr, actualErr);
	  
  }
  @Test(priority =3)
  public void incorrectusernameandnopassword() throws InterruptedException {
	  
	 	
	  driver.findElement(By.id("userName")).sendKeys("ash%%12dsjbdsm");
	  driver.findElement(By.id("password")).sendKeys("");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@type = 'button']")).click();
		
		
		
		/* Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		
		al.dismiss(); */

	  Thread.sleep(4000);
	 String expectedErr = "Password is required.";
	  String actualErr = driver.findElement(By.className("d2l-link")).getText();
	  System.out.println(actualErr);
	  Assert.assertEquals(expectedErr, actualErr);
	  
  }
}
