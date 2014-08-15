

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	 
	 	@FindBy(how = How.ID, using = "confirmation_token")
	    WebElement confCode;
	 	
	 	@FindBy(how = How.ID, using = "btnActivate")
	    WebElement activate;
	 	
	 	String title="Confirmation";
	 
	public ConfirmationPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
      
	}

	
	 
	 public UserActivation gotoUserAct(String confCodes){
		 
		 
		 try{
			 wait.until(ExpectedConditions.visibilityOf(activate));
			 Assert.assertTrue(driver.getTitle().contains(title));
			 Assert.assertTrue(activate.isDisplayed());
			 Thread.sleep(30000);
			 System.out.println("Waiting for 30 seconds to enter confirmation code");
			 System.out.println("Enter Confirmation Code got in email in the confirmation Code Box and wait!");
			 //confCode.sendKeys(confCodes);
			 activate.click();
			 return new UserActivation(driver,wait);
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 return null;
		 }
		 
	}


}
