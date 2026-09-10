package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatlogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatlogue(WebDriver driver) {
		super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	
	//PageFactory
//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
@FindBy(css=".mb-3")
List<WebElement> products;
 By productsBy =By.cssSelector(".mb-3");
 @FindBy(css=".ng-animating")
 WebElement  spinner;
By addToCart =  By.cssSelector(".card-body button:last-of-type");
By toastMessage =By.cssSelector("#toast-container");
public List<WebElement> getProductList() {
	waitForElementToAppear(productsBy);
	return products;
}
public WebElement getProductByName(String productName)
{
	WebElement prod = getProductList().stream().filter(product->                                                                //If we need any web element, then use filter out.
	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return prod;
}
public void addProductToCart(String productName) throws InterruptedException
{
//	Thread.sleep(1000);
	WebElement prod =getProductByName(productName);
	prod.findElement(addToCart).click();
	waitForElementToAppear(toastMessage);
	waitForElementToDisappear(spinner);
	waitForElementToDisappear(toastMessage);
}
}