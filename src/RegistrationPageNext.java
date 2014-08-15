

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageNext {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	 	@FindBy(how = How.ID, using = "email_field")
	    WebElement email;
	    
	    @FindBy(how = How.ID, using = "user_name")
	    WebElement fullname;
	    
	    @FindBy(how = How.ID, using="submit_new")
	    WebElement createAccount;
	 
	public RegistrationPageNext(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
     
	}

	
	 public ConfirmationPage goToConfPage(String myemail,String fname){
		 wait.until(ExpectedConditions.visibilityOf(createAccount));
		 email.sendKeys(myemail);
		 fullname.sendKeys(fname);
		 createAccount.click();
		 
		 return new ConfirmationPage(driver,wait);
	}

}
