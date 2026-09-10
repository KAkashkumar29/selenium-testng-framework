package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatlogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatlogue productCatalogue = landingPage.loginApplication("akashselenium@gmail.com", "Akash1@7886");
	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatlogue productCatalogue = landingPage.loginApplication("akashselenium@gmail.com", "Akash@7886");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}
