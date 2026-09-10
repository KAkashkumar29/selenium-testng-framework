package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatlogue;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider ="getData",groups = {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		ProductCatlogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.searchCounty("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		//"ZARA COAT 3";
		ProductCatlogue productCatalogue = landingPage.loginApplication("akashselenium@gmail.com", "Akash@7886");
         OrderPage ordersPage = productCatalogue.goToOrdersPage();
       Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
         
	}
	
	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+ testCaseName + ".png";
	}
	
	//Extent Reports - 
	@DataProvider
	public Object[][] getData() throws IOException
	{

		List<HashMap<String,String>>  data = getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/rahulshettyacademy/data/PurchaseOrder.json");
	 return 	new Object[][] {{data.get(0)}, {data.get(1)} };
	}
	
	
	
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][]  {{"akashselenium@gmail.com","Akash@7886","ZARA COAT 3"},{"akash21@gmail.com","Akash@7886","ADIDAS ORIGINAL"}};
//	}
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "akashselenium@gmail.com");
//	map.put("password", "Akash@7886");
//	map.put("product", "ZARA COAT 3");
//	
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "akash21@gmail.com");
//	map1.put("password", "Akash@7886");
//	map1.put("product", "ADIDAS ORIGINAL");
}
