import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;
@SuppressWarnings("unused")
public class parametars {

	
	static  WebDriver Driver =new ChromeDriver();
	String TheWebSite ="https://magento.softwaretestingboard.com/";
	Assertion MyAssert =new Assertion() ;
	String FirstName ="Ahmad";
	String LastName ="AlSmadi";
	String Email ="Ahmadsmadi1996@hotmail.com";
	String Pass ="Ahmad@123Smadi";
	String ExpectedText ="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
	Random Rand=new Random();
	String ExpectedMassage = "The requested qty is not available";
	static String TheHomePage = "https://magento.softwaretestingboard.com/";
	double ExpectedPricsFor5Invoices = 270.80 ;



	
}
