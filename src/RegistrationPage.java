

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	 	@FindBy(how = How.ID, using = "user_company")
	    WebElement usercompany;
	    
	    @FindBy(how = How.ID, using = "user_user_phone")
	    WebElement user_phone;
	     
	    @FindBy(how = How.ID, using = "user_bbdc")
	    WebElement bigdataChallange;
	    
	    @FindBy(how = How.ID, using="step1to2")
	    WebElement nextStep;
	 
	public RegistrationPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	
	 public RegistrationPageNext gotoNextPage(String userc,String userphone, String bdc){
		
		 wait.until(ExpectedConditions.visibilityOf(nextStep));
		 usercompany.sendKeys(userc);
		 user_phone.sendKeys(userphone);
		 bigdataChallange.sendKeys(bdc);
		 nextStep.click();
		 
		 return new RegistrationPageNext(driver,wait);
	}
}
