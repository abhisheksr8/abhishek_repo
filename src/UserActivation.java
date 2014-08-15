

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserActivation {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	 	@FindBy(how = How.ID, using = "user_password")
	    WebElement password;
	 	
	 	@FindBy(how = How.ID, using = "user_password_confirmation")
	    WebElement cpassword;
	 	
	 	@FindBy(how = How.ID, using = "btnPasswordActivate")
	    WebElement submitn;
	 	
	 	String title="User Activation";
	 
	public UserActivation(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
       
	}

	
	 
	 public QuboleWebApp gotoHome(String pwd){
		 
		 	wait.until(ExpectedConditions.visibilityOf(submitn));
		 	Assert.assertTrue(driver.getTitle().contains(title));
		 	password.sendKeys(pwd);
			cpassword.sendKeys(pwd);
			submitn.click();
			return new QuboleWebApp(driver,wait);
	}


}
