
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateAccountAutomate {
	
	private static WebDriverWait wait;
    private static WebDriver driver=null;
    private static String OS = System.getProperty("os.name").toLowerCase();
    
    String pwd="Welcome1";
    String mob="9902020202";
    String bdc="I want to analyze my MongoDB";
    String email="anilsriv56@def.com";
    String name="Ankush Khanna";
    String cmpny="ABCD Inc.";
    String confCode="abcdef";
    
    LoginPage lp;
    RegistrationPage rp1;
    RegistrationPageNext rp2;
    ConfirmationPage cp;
    UserActivation ua;
    QuboleWebApp qwa;
    
    @BeforeClass
    @Parameters("url")
    public  static void setUp(String url) 
    {
        try 
        {
        	if(OS.indexOf("win") >= 0)
            {
                  DesiredCapabilities dc = new DesiredCapabilities();
                  dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
                  dc.setJavascriptEnabled(true);
                  dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                  dc.setCapability(CapabilityType.SUPPORTS_ALERTS, true);

                  driver = new FirefoxDriver(dc);

            }
             else if(OS.indexOf("lin") >= 0 || OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
                  FirefoxProfile profile = new FirefoxProfile();
                  profile.setAcceptUntrustedCertificates(true);
                  profile.setAssumeUntrustedCertificateIssuer(false);
                  driver = new FirefoxDriver(profile);
            }

    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		driver.get(url);
    		driver.manage().window().maximize();
    		wait = new WebDriverWait(driver, 20);
        } 
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }

    }
     
    
    @Test
   	public void testA_registerNewUser(){
   		try{
   			
   		    
   		    lp=new LoginPage(driver,wait);
   			PageFactory.initElements(driver, lp);
   			
   			rp1=lp.registerNow();
   			PageFactory.initElements(driver, rp1);	
   			
   			
   			rp2=rp1.gotoNextPage(cmpny,mob,bdc);
   			PageFactory.initElements(driver, rp2);	
   			
   			cp=rp2.goToConfPage(email,name);
   			PageFactory.initElements(driver,cp);
   			
   			ua=cp.gotoUserAct(confCode);
   			PageFactory.initElements(driver,ua);
   			
   			qwa=ua.gotoHome(pwd);
   			PageFactory.initElements(driver,qwa);
   			
   			
   		}
   		catch(Exception t){
   			t.printStackTrace();
   		}
   		
   	}
      
     @Test
   	 public void testB_Logout(){
   			try{
   				lp=qwa.logout();	
   				PageFactory.initElements(driver,lp);
   			}
   			catch(Exception t){
   				t.printStackTrace();
   			}
   			
   	}
     
     @Test
   	 public void testC_LoginAgain(){
   			try{
   				lp.login(email, pwd);	
   			}
   			catch(Exception t){
   				t.printStackTrace();
   			}
   			
   	}

    
    @AfterClass
	 public static void teardown()
	 {
	 	   driver.quit();
	 }


}
