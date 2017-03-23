package First;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SPA {
	public static void AssertString(String actualTitle,String expectedTitle ){
	    System.out.println("Actual -"+actualTitle);
	    System.out.println("Expected -"+expectedTitle);
       Assert.assertTrue(actualTitle.contains(expectedTitle),"Strings are not Equal");
 }
	
	
	public static void main(String args[])throws Exception{  
		 System.setProperty("webdriver.chrome.driver","D:\\workspace\\BB_UB_Integration\\drivers\\chromedriver.exe");
		 WebDriver driver= new ChromeDriver();
		 
		driver.get("http://10.0.21.243:9000");
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		
		 
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("niteshnegi.0@gmail.com");
		 driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Qait@123");
		 driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		 Thread.sleep(50000);
         
		 boolean f5=	 driver.findElement(By.xpath("(//a[contains(text(),'Reports')])[1]")).isDisplayed();
	     if(f5==false)
	     {
	    System.out.println("Error occured");
	    driver.navigate().refresh();
		
	    }
	    else
		System.out.println("No error displayed");
		
		 
		 
		 AssertString(driver.getTitle(),"Mapworks - Overview");	
		 System.out.println("User is on Skyfactor Mapworks Homepage");
		 
		 driver.findElement(By.xpath("(//a[contains(text(),'Reports')])[1]")).click();
		 Thread.sleep(15000);
		 AssertString(driver.getTitle(),"Mapworks - Reports");	
		 System.out.println("User is on Skyfactor Mapworks Report page");
		 
		 
		 boolean f2=	 driver.findElement(By.xpath("(//a[contains(text(),'Outcomes Comparison')])[1]")).isDisplayed();
	     if(f2==true)
	     {
	    System.out.println("Outcome Comparison Report is displayed");
		
	    }
	    else
		System.out.println("Not displayed");
	     
	     driver.findElement(By.xpath("//a[contains(text(),'Outcomes Comparison Report')]")).click();
	     Thread.sleep(2000);
	     
		  String winHandleBefore = driver.getWindowHandle();
	          driver.switchTo().window(winHandleBefore);
	String x=	 driver.findElement(By.xpath("//span//strong[contains(text(),'Outcomes Comparison Report')]")).getText();
	System.out.println(x);
	Assert.assertTrue(x.contains("Outcomes Comparison Report"));
		 
	String x2=	 driver.findElement(By.xpath("//span[contains(text(),'Select Subpopulation Attribute')]")).getText();
	System.out.println(x2);
	Assert.assertTrue(x2.contains("Select Subpopulation Attribute"));
		
		 WebElement  RadioBtn = driver.findElement (By.xpath("//label[contains(text(),'Profile Item or Institution-Specific Profile Item (ISP)')]"));

		 RadioBtn.click();
		 
		 boolean f3=RadioBtn.isSelected();
				 if(f3==true)
	     {
	    System.out.println("ISP Radio button is selected by default");
		
	    }
	    else
		System.out.println("Not Enable");
		 
	    WebElement Radiobtn2= driver.findElement(By.xpath("//label[contains(text(),'Survey Question or Institution-Specific Survey Question (ISQ)')]"));
				 
		boolean f4= Radiobtn2.isSelected();
		if(f4==true)
		{
			 System.out.println("ISQ Radio button is selected by default");
			
		}
		 else
				System.out.println("ISQ radio button is Not selected");	
	
		
	    
		
		WebElement toolTipElement = driver.findElement(By.xpath("//a[@id='help-tooltip']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(toolTipElement).build().perform();
		
		String toolTipText = toolTipElement.getText();
		
		System.out.println(toolTipText);
		
		Assert.assertEquals("", toolTipText);

		System.out.println("Assertion passed");
		
		driver.findElement(By.xpath("//input[@class='mw-primary-button save-button']")).click();
		Thread.sleep(2000);
		
		String x3=	 driver.findElement(By.xpath("//span[contains(text(),'Select Profile Item')]")).getText();
		System.out.println(x3);
		Assert.assertTrue(x3.contains("Select Profile Item"));
		Thread.sleep(15000);
		
		
		if(driver.findElement(By.xpath("//tree-node[@class='outline-border ng-isolate-scope']//div[@class='ng-scope']")).isDisplayed())
	    
		{
	   
		int i;
		for(i=1;i<=16;i++){
			
			String Tree =	driver.findElement(By.xpath("//tree-node[@class='outline-border ng-isolate-scope']//div[@class='ng-scope']["+i+"]")).getText();
			System.out.println(Tree);
			System.out.println("All 16 Profile Blocks are present");
			
		}
		}else{
		
		System.out.println("No Profile blocks are displayed");
	    System.out.println("Close the Pop up window and start again");
	    driver.findElement(By.xpath("//a[@class='mw-close-button']"));
	    driver.findElement(By.xpath("//a[contains(text(),'Outcomes Comparison Report')]")).click();
      
		driver.findElement(By.xpath("//input[@class='mw-primary-button save-button']")).click();
		
	
		Thread.sleep(20000);
		int j;
		for(j=1;j<=16;j++){
		String Tree =	driver.findElement(By.xpath("//tree-node[@class='outline-border ng-isolate-scope']//div[@class='ng-scope']["+j+"]")).getText();
		System.out.println(Tree);
		}
		}

		driver.findElement(By.xpath("(//tree-node[@class='outline-border ng-isolate-scope']//div[@class='ng-scope'])[1]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'CulturalEvents')]")).click();
		driver.findElement(By.xpath("//input[@class='mw-primary-button save-button']")).click();
		
		Thread.sleep(15000);
		String x5=	 driver.findElement(By.xpath("//span[contains(text(),' CulturalEvents')]")).getText();
		System.out.println(x5);
		Assert.assertTrue(x5.contains("CulturalEvents"));
		
		driver.findElement(By.xpath("//input[@id='subpopulation1Name']")).sendKeys("Attend");
		driver.findElement(By.xpath("//input[@id='subpopulation2Name']")).sendKeys("Not Attend");
		
		String x6=	 driver.findElement(By.xpath("//p[@id='subpopulation1SingleRadio']")).getText();
		System.out.println(x6);
		Assert.assertTrue(x6.contains("Single"));
		
		String x7=	 driver.findElement(By.xpath("//p[@id='subpopulation1RangeRadio']")).getText();
		System.out.println(x7);
		Assert.assertTrue(x7.contains("Range"));
		
		
		
		
		System.out.println("Clicking Breadcrumb");
		driver.findElement(By.xpath("//a[contains(text(),'Select Type')]")).click();
		System.out.println("Clicked");
		
		String x8=	 driver.findElement(By.xpath("//span[contains(text(),'Select Subpopulation Attribute')]")).getText();
		System.out.println(x8);
		Assert.assertTrue(x8.contains("Select Subpopulation Attribute"));
		
		driver.findElement(By.xpath("//label[contains(text(),'Survey Question or Institution-Specific Survey Question (ISQ)')]")).click();
		
		driver.findElement(By.xpath("//input[@class='mw-primary-button save-button']")).click();
		
		
		String x9=	 driver.findElement(By.xpath("//span[contains(text(),'Select one Cohort from one Survey')]")).getText();
		System.out.println(x9);
		Assert.assertTrue(x9.contains("Select one Cohort from one Survey"));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//tree-node[@class='outline-border ng-isolate-scope']//div[@class='ng-scope'])[1]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Transition One')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Survey Cohort 1')]")).click();
		
		driver.findElement(By.xpath("//input[@class='mw-primary-button save-button']")).click();
		
		Thread.sleep(15000);
		
		boolean f6=	 driver.findElement(By.xpath("//div[contains(text(),'How satisfied were you with your Orientation leader?')]")).isDisplayed();
	     if(f6==false)
	     {
	    System.out.println("No Questions available");
	    driver.findElement(By.xpath("//a[@class='mw-close-button']"));
	    driver.findElement(By.xpath("//a[contains(text(),'Outcomes Comparison Report')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Survey Question or Institution-Specific Survey Question (ISQ)')]")).click();
		
		driver.findElement(By.xpath("//input[@class='mw-primary-button save-button']")).click();
		Thread.sleep(10000);
        driver.findElement(By.xpath("(//tree-node[@class='outline-border ng-isolate-scope']//div[@class='ng-scope'])[1]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Transition One')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Survey Cohort 1')]")).click();
		
		driver.findElement(By.xpath("//input[@class='mw-primary-button save-button']")).click();
	    }
	    else{
		System.out.println("Questions are listed");
	    }
		
		driver.findElement(By.xpath("//div[contains(text(),'How satisfied were you with your Orientation leader?')]")).click();
		
		driver.findElement(By.xpath("//input[@class='mw-primary-button save-button']")).click();
		Thread.sleep(10000);
		 if(driver.findElement(By.xpath("(//input[@class='secondary-button nevermind'])[2]")).isEnabled())
		 {
		System.out.print("All Mandatory fields are Entered");
		}
		else{
			System.out.print("Now Enter All Manadory fields");
			driver.findElement(By.xpath("//input[@id='subpopulation1Name']")).sendKeys("Attend");
		    driver.findElement(By.xpath("//input[@id='subpopulation2Name']")).sendKeys("Not Attend");
		    Thread.sleep(5000);
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//table[@class='table table-striped']//td[@id='ans0']/following-sibling::td/input[@id='subpopulation1CheckboxCategory0']")).click();
		    driver.findElement(By.xpath("//table[@class='table table-striped']//td[@id='ans1']/following-sibling::td/input[@id='subpopulation2CheckboxCategory1']")).click();
		    
		    driver.findElement(By.xpath("(//input[@class='secondary-button nevermind'])[2]")).isEnabled();
			System.out.print("GReport button is enable");
		}
		
		 
		
	     
		
	}
	
}
	



	
