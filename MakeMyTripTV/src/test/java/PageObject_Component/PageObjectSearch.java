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

	@AndroidFindBy(id = "com.makemytrip:id/depDateLayout")
	public WebElement departure_date;

	@AndroidFindBy(name = "23")
	public WebElement departureDate;

	@AndroidFindBy(id = "com.makemytrip:id/calOK")
	public WebElement departureDateOK;
	
	@AndroidFindBy(id = "com.makemytrip:id/returnDateLayout")
	public WebElement returnDate;

	@AndroidFindBy(name = "25")
	public WebElement returnDateSelection;
	
	@AndroidFindBy(id = "com.makemytrip:id/travellerTextID")
	public WebElement adult_count;
	


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


	/*
	 * Deaprture Date Selection, Here Assumed Date is 23rd Jan'17
	 * 
	 */
	public void departure_Date() throws InterruptedException {
		departure_date.click(); 
		Thread.sleep(2000);
	}

	public void click_depDate() {
		departureDate.click(); 
	}

	public void click_depDateOK() throws InterruptedException {
		departureDateOK.click(); 
		Thread.sleep(2000);
	}

	
	/*
	 * Return Date selection, Here assumed Date is 25th Jan'17
	 * 
	 */

	public void returnDateSelection() throws InterruptedException {
		returnDate.click();
		Thread.sleep(2000);
	}
	
	public void click_returnDate() {
		returnDateSelection.click(); 
	}

	//We can still make a single method due to same id for OK Button in Calendar but I will go with unique
	public void click_returnDateOK() throws InterruptedException {
		departureDateOK.click(); 
		Thread.sleep(2000);
	}
	
	
	//Adult and Class selection
	public void select_AdultCnt() throws InterruptedException {
		adult_count.click(); 
		Thread.sleep(3000);
	}
	
	
	
}
