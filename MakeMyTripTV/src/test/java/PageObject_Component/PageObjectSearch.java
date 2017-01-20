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

	/*
	 * Departure and Arrival City are static, w.r.t Bangalore - Pune
	 */

	@AndroidFindBy(id = "com.makemytrip:id/activity_home_lc_flights_txtvw")
	public WebElement flghts;

	@AndroidFindBy(id = "com.makemytrip:id/depCity")
	public WebElement departure_city;

	@AndroidFindBy(id = "com.makemytrip:id/city_edit_text")
	public WebElement enter_cityName;

	@AndroidFindBy(name = "Bangalore")
	public WebElement searchCity;

	@AndroidFindBy(id = "com.makemytrip:id/arrCity")
	public WebElement arrival_city;

	@AndroidFindBy(name = "Pune")
	public WebElement searchArrCity;

	public void flight_search() {
		flghts.click(); 
	}


	/*
	 *****************Searching and Entering 'From' City Name************
	 */
	public void select_depCity() {
		departure_city.click(); 
	}

	public void enter_depCityName(String dpcity) throws InterruptedException {
		enter_cityName.click();
		Thread.sleep(3000);
		enter_cityName.sendKeys(dpcity);

	}

	public void select_searchedCity() throws InterruptedException {
		if(searchCity.isDisplayed()){
			searchCity.click(); 
		}
		Thread.sleep(3000);
	}


	/*
	 * ******************Searching and Entering 'To' City Name**************
	 */
	public void select_arrCity() {
		departure_city.click(); 
	}

	//City Edit Text WebElement declaration is already exist
	public void enter_arrCityName(String arrcity) throws InterruptedException {
		enter_cityName.click();
		Thread.sleep(3000);
		enter_cityName.sendKeys(arrcity);

	}

	public void select_searchedArrivalCity() throws InterruptedException {
		if(searchArrCity.isDisplayed()){
			searchArrCity.click(); 
		}
		Thread.sleep(3000);
	}
}
