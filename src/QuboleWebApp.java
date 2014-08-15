import junit.framework.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@SuppressWarnings("deprecation")
public class QuboleWebApp {
	private WebDriver driver;
	private WebDriverWait wait;
	
	 	@FindBy(how = How.XPATH, using = "//a[@href='https://colonelhathi.qubole.com/users/sign_out']")
	    WebElement logout;
	 	
	 	@FindBy(how = How.ID, using = "sidebar")
	    WebElement sidebar;
	 	
	 	String title="Analyze";
	 
	public QuboleWebApp(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public LoginPage logout(){
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 wait.until(ExpectedConditions.visibilityOf(sidebar));
		 Assert.assertTrue(driver.getTitle().contains(title));
	     // Click
	     js.executeScript("arguments[0].click();",logout);
		 return new LoginPage(driver,wait);
	}

}
