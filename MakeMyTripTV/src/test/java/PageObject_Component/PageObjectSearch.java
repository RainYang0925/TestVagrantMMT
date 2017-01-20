package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObjectSearch {

	public PageObjectSearch(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
 
	
	@AndroidFindBy(id = "com.makemytrip:id/activity_home_lc_flights_txtvw")
	public WebElement flghts;
 
	@AndroidFindBy(id = "com.makemytrip:id/depCity")
	public WebElement departure_city;
 
	@AndroidFindBy(id = "txtResult")
	public WebElement txtResult;
	
	public void flight_search() {
		flghts.click(); 
	}
 
	public void select_depCity() {
		departure_city.click(); 
	}
 
	/*public void flight_search(String flight_action) {
		flghts.sendKeys(num1);
		txtNum2.sendKeys(num2);
	}*/
}
