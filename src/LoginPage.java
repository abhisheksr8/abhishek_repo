

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage {

	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(how = How.ID, using = "user_email")
    WebElement userid;
    
    @FindBy(how = How.ID, using = "user_password")
    WebElement password;
    
    @FindBy(how = How.ID, using = "submit_new")
    WebElement button;
    
    @FindBy(how = How.XPATH, using="//a[@href='/users/sign_up']")
    WebElement register;
    
    String title="Sign In - Qubole Data Services (QDS)";
    
    public LoginPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait=wait;
        // Check that we're on the right page.
        if (!driver.getTitle().equals(title)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

	public QuboleWebApp login(String user,String pwd){
		
			wait.until(ExpectedConditions.visibilityOf(button));
			Assert.assertTrue(driver.getTitle().equals(title));
			Assert.assertTrue(button.isDisplayed());
			userid.sendKeys(user);
			password.sendKeys(pwd);
			button.click();
			System.out.println("After Click");
			return new QuboleWebApp(driver,wait);

	}
	
	public RegistrationPage registerNow(){
		
		wait.until(ExpectedConditions.visibilityOf(register));
		Assert.assertTrue(driver.getTitle().equals(title));
		Assert.assertTrue(register.isDisplayed());
		register.click();
		
		return new RegistrationPage(driver,wait);

	}
}
