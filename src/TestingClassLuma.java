import java.math.BigDecimal;
import java.util.List;

import javax.management.AttributeValueExp;

import org.apache.commons.io.file.DeleteOption;
import org.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor.ForReplacement;

@SuppressWarnings("unused")
public class TestingClassLuma extends parametars {

	@BeforeTest
	public void MyBeforeTest() {
		Driver.get(TheWebSite);

	}

	@Test(priority = 1)
	public void CreatAnAccaount() throws InterruptedException {
		WebElement CreatAccount = Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a"));

		CreatAccount.click();
		Driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(FirstName);

		Driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(LastName);
		Driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(Email);
		Driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Pass);
		Driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(Pass);
		Driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		Thread.sleep(2000);
		String ActulaText = Driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")).getText();
		MyAssert.assertEquals(ActulaText, ExpectedText);

		Driver.get(TheWebSite);

		Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
		Driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email);
		Driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Pass);
		Driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
	}

	@Test(priority = 2)
	public void SearchRandomItemsAndPrintTheName() throws InterruptedException {

		String[] Items = { "Jacket", "t-shirt", "jeans for man", "jeans for womwn", "pants" };
		int MyIndex = Rand.nextInt(0, 5);
		Driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(Items[MyIndex]);
		System.out.println(Items[MyIndex]);
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void Add5ItemsToTheCartWithRandomlySizeAndColor() throws InterruptedException {

		Thread.sleep(3000);

		WebElement RadiantTee = Driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/a/span/span/img"));
		RadiantTee.click();
		for (int i = 0; i < 3; i++) {

			Thread.sleep(2000);

			WebElement SizeXS = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]"));
			WebElement SizeS = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-167\"]"));
			WebElement SizeM = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
			WebElement SizeL = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-169\"]"));
			WebElement SizeXL = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-170\"]"));

			WebElement[] SizeOption = { SizeXS, SizeS, SizeM, SizeL, SizeXL };
			int MySizeIndex = Rand.nextInt(0, 5);
			SizeOption[MySizeIndex].click();

			Thread.sleep(3000);

			WebElement BlueColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-50\"]"));
			WebElement OrangeColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-56\"]"));
			WebElement PurpleColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-57\"]"));

			WebElement[] ColorOption = { BlueColor, OrangeColor, PurpleColor };
			int MyColorIndex = Rand.nextInt(0, 3);
			ColorOption[MyColorIndex].click();

			Thread.sleep(3000);

			WebElement AddToCartBotton = Driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
			AddToCartBotton.click();
			Thread.sleep(2000);
			Driver.navigate().refresh();

		}

		Thread.sleep(2000);

		Driver.get(TheHomePage);

		WebElement BreatheEasyTank = Driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]/div/a/span/span/img"));
		BreatheEasyTank.click();

		for (int i = 0; i < 2; i++) {

			Thread.sleep(2000);

			WebElement SizeXS = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]"));
			WebElement SizeS = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-167\"]"));
			WebElement SizeM = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
			WebElement SizeL = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-169\"]"));
			WebElement SizeXL = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-170\"]"));

			WebElement[] SizeOption = { SizeXS, SizeS, SizeM, SizeL, SizeXL };
			int MySizeIndex = Rand.nextInt(0, 5);
			SizeOption[MySizeIndex].click();

			Thread.sleep(3000);

			WebElement PurpleColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-57\"]"));
			WebElement YellowColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-60\"]"));
			WebElement WhiteColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-59\"]"));

			WebElement[] ColorOption = { YellowColor, WhiteColor, PurpleColor };
			int MyColorIndex = Rand.nextInt(0, 3);
			ColorOption[MyColorIndex].click();

			Thread.sleep(3000);

			WebElement AddToCartBotton = Driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
			AddToCartBotton.click();
			Thread.sleep(2000);
			Driver.navigate().refresh();

		}

		Driver.get(TheHomePage);
		Thread.sleep(2000);

		WebElement ArgusAll_WeatherTank = Driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/a/span/span/img"));
		ArgusAll_WeatherTank.click();
		Thread.sleep(2000);

		for (int i = 0; i < 4; i++) {

			Thread.sleep(2000);

			WebElement SizeXS = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]"));
			WebElement SizeS = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-167\"]"));
			WebElement SizeM = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
			WebElement SizeL = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-169\"]"));
			WebElement SizeXL = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-170\"]"));

			WebElement[] SizeOption = { SizeXS, SizeS, SizeM, SizeL, SizeXL };
			int MySizeIndex = Rand.nextInt(0, 5);
			SizeOption[MySizeIndex].click();

			Thread.sleep(3000);

			WebElement GrayColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]"));

			GrayColor.click();

			WebElement AddToCartBotton = Driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
			AddToCartBotton.click();
			Thread.sleep(2000);
			Driver.navigate().refresh();

		}

		Driver.get(TheHomePage);

		Thread.sleep(2000);

		WebElement HeroHoodie = Driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/a/span/span/img"));
		HeroHoodie.click();
		Thread.sleep(2000);
		WebElement SizeXS = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]"));
		WebElement SizeS = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-167\"]"));
		WebElement SizeM = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
		WebElement SizeL = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-169\"]"));
		WebElement SizeXL = Driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-170\"]"));

		WebElement[] SizeOption = { SizeXS, SizeS, SizeM, SizeL, SizeXL };
		int MySizeIndex = Rand.nextInt(0, 5);
		SizeOption[MySizeIndex].click();

		Thread.sleep(3000);

		WebElement BlackColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-49\"]"));
		WebElement GrayColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]"));
		WebElement GreenColor = Driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-53\"]"));

		WebElement[] ColorOption = { BlackColor, GrayColor, GreenColor };
		int MyColorIndex = Rand.nextInt(0, 3);
		ColorOption[MyColorIndex].click();

		Thread.sleep(3000);

		WebElement AddToCartBotton = Driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		AddToCartBotton.click();
		Thread.sleep(2000);
		Driver.navigate().refresh();

		Thread.sleep(2000);

		Driver.get(TheHomePage);

		Thread.sleep(2000);

		

	}

	
	@Test(priority = 4)
	public void FusionBackpackAddToCart5Times () throws InterruptedException {
		
		
		Driver.get(TheHomePage);
		
		WebElement FusionBackpack = Driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[5]/div/a/span/span/img"));

		FusionBackpack.click();
		Thread.sleep(2000);

		WebElement BackpackQty = Driver.findElement(By.xpath("//*[@id=\"qty\"]"));
		BackpackQty.clear();
		BackpackQty.sendKeys("5");
		Thread.sleep(3000);
		
		WebElement AddToCartBotton2 = Driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		AddToCartBotton2.click();
		
		Thread.sleep(5000);
		WebElement ActualMassage = Driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div"));
		String ActualMassageValue = ActualMassage.getText();
		MyAssert.assertEquals(ActualMassageValue, ExpectedMassage);
		System.out.println("This Item (Fusion Backpack) Is Out Of Stock");
		
		

		Thread.sleep(7000);
	}
	@Test(priority = 5)
	public void ShippingAddressInfo() throws InterruptedException {
		
		Thread.sleep(2000);

		WebElement Cart = Driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a/span[2]/span[1]"));
		Cart.click();

		Thread.sleep(2000);
		WebElement ProceedToCheckoutBotton = Driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
		ProceedToCheckoutBotton.click();
		Thread.sleep(10000);
		
		String ExpectedAddress = "Shipping Address";
		WebElement ActualAddress = Driver.findElement(By.xpath("//*[@id=\"shipping\"]/div[1]"));
		ActualAddress.getText();
		
		if (ExpectedAddress.equalsIgnoreCase(ActualAddress.getText()) ) {
			
			
			
			
			WebElement Nextbotton =Driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
			Nextbotton.click();
			Thread.sleep(6000);
			
			
			WebElement PlaceOrder = Driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"));
			PlaceOrder.click();
			
		}
			
			
			else {
				
				
			//=============> If there is no address The code below create anew address 

		WebElement CountryField = Driver.findElement(By.cssSelector("select[name='country_id'"));
		CountryField.click();

		CountryField.sendKeys("j", "j", "j", "j", Keys.ENTER);
		WebElement CompanyField = Driver.findElement(By.cssSelector("input[name='company'"));
		CompanyField.sendKeys("Ahmad Company");

		WebElement StreetAddressField1 = Driver.findElement(By.cssSelector("input[name='street[0]'"));
		StreetAddressField1.sendKeys("Al-Shaheed Ahmad Al-Baradleh");

		WebElement StreetAdressField2 = Driver.findElement(By.cssSelector("input[name='street[1]'"));
		StreetAdressField2.sendKeys("Jerash Street ");

		WebElement StreetAdressField3 = Driver.findElement(By.cssSelector("input[name='street[2]'"));
		StreetAdressField3.sendKeys("Al-Qirwan Street");

		WebElement CityField = Driver.findElement(By.cssSelector("input[name='city'"));
		CityField.sendKeys("Jerash");

		WebElement StateProvinceField = Driver.findElement(By.cssSelector("input[name='region'"));
		StateProvinceField.sendKeys("Jerash");

		WebElement ZipPostalCodeField = Driver.findElement(By.cssSelector("input[name='postcode'"));
		ZipPostalCodeField.sendKeys("26833");

		WebElement PhoneNumberField = Driver.findElement(By.cssSelector("input[name='telephone'"));
		PhoneNumberField.sendKeys("00962776099745");

		WebElement NextBotton = Driver
				.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));

		NextBotton.click();
		}
		
		
			Thread.sleep(4000);
			WebElement YourOrderNumber =Driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a/strong"));
			YourOrderNumber.click();
//***************************************************************************************************
//	 WebElement CompanyField =
//	 Driver.findElement(By.xpath("//*[@id=\"H14K21M\"]"));

	// ======> Trying To Find Element By Tag Name & Class Name

//	    WebElement LiField =Driver.findElement(By.className("checkout-shipping-address"));
//		List<WebElement> listOfInput =LiField.findElements(By.tagName("input"));
//		String CheckAttribute = LiField.getAttribute("name");
//		String ttt =attributeValue.substring(0, 11);
//		System.out.println(listOfInput);
//		System.out.println(CheckAttribute);
	 }
	@Test(priority = 6)
	public void ChickThePrice() throws InterruptedException {

		// =======> Short Cut
//		String Url = "https://magento.softwaretestingboard.com/sales/order/view/order_id/9012/";
//		Driver.get(Url);

		Thread.sleep(10000);


		WebElement TFoot = Driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot"));

		List<WebElement> PriceElement = TFoot.findElements(By.className("price"));

		double Subtotal = Double.parseDouble(PriceElement.get(0).getText().replace("$", ""));
		double ShippingHandling = Double.parseDouble(PriceElement.get(1).getText().replace("$", ""));
		double Discount = Double.parseDouble(PriceElement.get(2).getText().replace("$", ""));
		double GrandTotal = Double.parseDouble(PriceElement.get(3).getText().replace("$", ""));
		
		double ExpectedPrics = Subtotal + ShippingHandling + Discount;
		double ActualPrics = GrandTotal;
		
		MyAssert.assertEquals(ActualPrics, ExpectedPrics, 0.00001);
		
		//=============================================================================================
//*****************************************************************************************************
//		failed trying to catch the elements 
//	    WebElement SubtotalElement = Driver.findElement(By.className("subtotal-amount"));
//        WebElement ShippingHandlingElement = Driver.findElement(By.className("shipping-amount"));
//        WebElement DiscountElement = Driver.findElement(By.className("discount-amount"));
//        WebElement GrandTotalElement =Driver.findElement(By.className("grand_total-amount"));
//        // Get the values from the elements
//        double Subtotal = Double.parseDouble(SubtotalElement.getText().replace("$", ""));
//        double ShippingHandling = Double.parseDouble(ShippingHandlingElement.getText().replace("$", ""));
//        double Discount = Double.parseDouble(DiscountElement.getText().replace("$", ""));
//        double GrandTotal =Double.parseDouble(GrandTotalElement.getText().replace("$", ""));
//        // Calculate final price
//        double ExpectedFinalPrice = Subtotal + ShippingHandling - Discount;
//        double ActualFinalPrics = GrandTotal;
//
//        // Assert the final price is correct
//        double expectedFinalPrice = 100.0; // Replace with your expected value
//        MyAssert.assertEquals(ActualFinalPrics, ExpectedFinalPrice, 0.001);	

//		WebElement Subtotal =Driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot/tr[1]/td/span"));
//		
//		String SubtotalWithoutDollarSign = ThePrices.get(0).getText();
//		
		// ======> Convert String To Integer
		// int ValueOfSubtotal =Integer.parseInt(SubtotalWithoutDollarSign);

//		Double DoubleValueSubtotal = Double.parseDouble(SubtotalWithoutDollarSign);

//		
//		//*[@id="my-orders-table"]/tfoot/tr[3]/td/span
//		WebElement DiscountValue =Driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot/tr[2]/td/span"));
//		String DiscountValueWithoutDollarSign =DiscountValue.getText().substring(2);
//		// ======> Convert String To Integer
//		//int ValueOfDiscountValue = Integer.parseInt(DiscountValueWithoutDollarSign);
//		
//		Double DoubleValueDiscount = Double.parseDouble(DiscountValueWithoutDollarSign);
//	
//		
//		WebElement ShippingAndHandling =Driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot/tr[3]/td/span"));
//		String ShippingAndHandlingWithOutDollarSign =ShippingAndHandling.getText().substring(1);
//		// ======> Convert String To Integer
//		//int ValueOfShippingAndHandling =Integer.parseInt(ShippingAndHandlingWithOutDollarSign);
//		Double DoubleValueShipping =Double.parseDouble(ShippingAndHandlingWithOutDollarSign);
//		Double ExpectedTotalPrice =  DoubleValueSubtotal  + DoubleValueShipping - DoubleValueDiscount ;
//		
//		System.out.println(ExpectedTotalPrice);
//
//		
//		
//	WebElement ActualTotalPrice =Driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot/tr[4]/td/strong/span"));
//	String ActualTotalPriceValue = ActualTotalPrice.getText().substring(1);
//	Double DoubleValueActualTotalPrice = Double.parseDouble(ActualTotalPriceValue);
//	
//	System.out.println(DoubleValueActualTotalPrice);
//	
//	MyAssert.assertEquals(DoubleValueActualTotalPrice, ExpectedTotalPrice , 0.0001);

		// ====> Try To Find Element By Tag name & Class Name

//		WebElement Item1 = Driver.findElement(By.tagName("tr"));
//		//Item1.getText();
//		WebElement ItemId1 = Item1.findElement(By.tagName("td"));
//		WebElement Item1Span1 =ItemId1.findElement(By.tagName("span"));
//		WebElement Item1Span2 =Item1Span1.findElement(By.tagName("span"));
//		WebElement Item1Span3=Item1Span2.findElement(By.tagName("span"));
//		WebElement Item1Price =Item1Span3.findElement(By.className("price"));
//		Item1Price.getText();
//		//ItemId1.getText();
//		
//		System.out.println(Item1Price);

//		List<WebElement> price_excluding_tax = Driver.findElements(By.className("price-excluding-tax"));
//		
//		System.out.println(price_excluding_tax.size());
		// for (int i =0 ;i<location_OF_Price.size();i++) {

//			List<WebElement>ThePrices = Driver.findElements(By.className("price"));
//			
//			for (int y=0 ; y<location_OF_Price.size();y++) {
//				System.out.println(ThePrices.get(y).getText());

//			}
		// System.out.println(location_OF_Price.get(i).findElement(By.className("price")));

		

		WebElement CustomerWelcome =Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]"));
		CustomerWelcome.click();
		WebElement SignOutElement =Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
		SignOutElement.click();
		
		
	}

	
	
	@Test(priority = 7)
	public void ReInter_The_WebSite_And_ReOrder () throws InterruptedException {
		
		Driver.get(TheWebSite);
		
		WebElement SignInElement = Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a"));
		
		SignInElement.click();
		
		WebElement EmailElement = Driver.findElement(By.xpath("//*[@id=\"email\"]"));
		EmailElement.sendKeys(Email);
		
		WebElement PassElement =Driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		PassElement.sendKeys(Pass);
		
		WebElement SignInBotton =Driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		SignInBotton.click();
		Thread.sleep(8000);
		
		WebElement CustomerWelcome =Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]"));
		CustomerWelcome.click();
		
		WebElement MyAccountElement = Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a"));
		MyAccountElement.click();
		
		WebElement MyOrderElement =Driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a"));
		MyOrderElement.click();
		
		
		for (int i=0 ; i<5; i++) {
			WebElement ReOrderBotton =Driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[2]/span"));
			ReOrderBotton.click();
			
			WebElement ProceedToCheckOutBotton =Driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button"));
			ProceedToCheckOutBotton.click();
			Thread.sleep(7000);
			WebElement NextBotton =Driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
			NextBotton.click();
			Thread.sleep(7000);
			WebElement PlaceOrderBotton =Driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"));
			PlaceOrderBotton.click();
			Thread.sleep(7000);
			WebElement ContinueShoppingBotton =Driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/div/a"));
			ContinueShoppingBotton.click();
			Thread.sleep(7000);
			WebElement CustomerWelcome2 =Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button"));
			CustomerWelcome2.click();
			Thread.sleep(7000);
			WebElement MyAccountElement2 =Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a"));
			MyAccountElement2.click();
			Thread.sleep(7000);	
			WebElement MyOrderElement2 =Driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a"));
			MyOrderElement2.click();
			Thread.sleep(7000);
			
		}
		
	}
		
		
		
		
		@Test(priority = 8)
		public void CheckLast5InvoicesSamePrice () throws InterruptedException {
		WebElement TBody = Driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody"));

		List<WebElement> PriceElement2 = TBody.findElements(By.className("price"));

		
		
		 

	        
	        for (int y=0 ;y<5;y++) {
	        	
	       double ActualPricsFor5Invoices=Double.parseDouble(PriceElement2.get(y).getText().replace("$", ""));  
	       Thread.sleep(2000);
	      // System.out.println(ActualPricsFor5Invoices);
	       MyAssert.assertEquals(ActualPricsFor5Invoices, ExpectedPricsFor5Invoices, 0.00001);
	            
	    }
		
		
	
	        
		
		
	}
			
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
