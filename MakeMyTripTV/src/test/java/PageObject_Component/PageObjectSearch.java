package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;
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

	//Assuming Adult = 1
	@AndroidFindBy(id = "com.makemytrip:id/okPax")
	public WebElement adult_countOK;

	@AndroidFindBy(id = "com.makemytrip:id/classTextID")
	public WebElement class_Selection;

	//Class Category
	@AndroidFindBy(id = "com.makemytrip:id/economyClass")
	public WebElement class_Type;

	//Search Flights
	@AndroidFindBy(id = "com.makemytrip:id/searchFlights")
	public WebElement seach_Flights;

	//Assuming default price is OK, Booking Initiated..
	@AndroidFindBy(id = "com.makemytrip:id/split_book_btn")
	public WebElement click_Booking;

	//Continue
	@AndroidFindBy(id = "com.makemytrip:id/continue_text")
	public WebElement click_Continue;

	//Add Adult
	@AndroidFindBy(id = "com.makemytrip:id/traveller_add_new_pax_text")
	public WebElement add_Adult;

	//Adding Adult Details
	@AndroidFindBy(id = "com.makemytrip:id/pax_first_name")
	public WebElement first_Name;

	@AndroidFindBy(id = "com.makemytrip:id/pax_last_name")
	public WebElement last_Name;

	//Done Button
	@AndroidFindBy(id = "com.makemytrip:id/pax_add_traveller_button")
	public WebElement click_Done;

	//Done Button
	@AndroidFindBy(id = "com.makemytrip:id/book_flight_text_view")
	public WebElement click_BookFlight;

	//Agree and Continue
	@AndroidFindBy(id = "com.makemytrip:id/flight_agree_insurance_button")
	public WebElement click_AgreeContinue;

	//Continue with final fare details
	@AndroidFindBy(id = "com.makemytrip:id/button_fare_change_continue")
	public WebElement click_FinalContinue;


	//---------------------------------------------------------------

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

	//Taking adult count As 1
	public void adultCount_OK() {
		adult_countOK.click(); 
	}

	//Class Category

	public void click_ClassType() {
		class_Selection.click(); 
	}

	//Assuming Economy Class is our Test Data
	public void click_ClassTypeSelected() {
		class_Type.click(); 
	}

	//Search Flights

	public void search_Flights() throws InterruptedException {
		seach_Flights.click(); 
		Thread.sleep(10000);
	}

	/*
	 * ----------------------------------------------------------------------
	 * Assuming default price selection among the search result is OK and
	 * Initiating Booking Process
	 * ----------------------------------------------------------------------
	 */

	public void booking_Init() throws InterruptedException {
		click_Booking.click(); 
		Thread.sleep(6000);
	}

	/*
	 * --------------------------------------------------------------
	 * Assuming default Insurance selection is OK
	 * --------------------------------------------------------------
	 */

	public void click_ContinueBooking() throws InterruptedException {
		click_Continue.click(); 
		Thread.sleep(6000);
	}

	/*
	 * ----------------------------------------------------
	 * Adding Adult Details as following Test Data
	 * First Name: Raman
	 * Last Name : Hullur
	 * Gender: Male
	 * --------------------------------------------------------
	 */

	public void click_AddNewAdult() throws InterruptedException {
		add_Adult.click(); 
		Thread.sleep(2000);
	}

	public void enter_FirstLastName(String fname, String lname) throws InterruptedException {
		first_Name.click();
		Thread.sleep(2000);

		//Handling Soft Keyboard Popup
		BaseClass.driver.sendKeyEvent(AndroidKeyCode.BACK);
		first_Name.sendKeys(fname);

		last_Name.click();
		Thread.sleep(2000);

		//Handling Soft Keyboard Popup
		BaseClass.driver.sendKeyEvent(AndroidKeyCode.BACK);
		last_Name.sendKeys(lname);

		//Gender TD default: Male

	}

	public void click_DoneButton() throws InterruptedException {
		click_Done.click(); 
		Thread.sleep(2000);
	}

	public void click_BookFlightButton() throws InterruptedException {
		click_BookFlight.click(); 
		Thread.sleep(2000);
	}

	public void click_AgreeContinueButton() throws InterruptedException {
		click_AgreeContinue.click(); 
		Thread.sleep(2000);
	}

	public void click_ContinuePriceButton() throws InterruptedException {
		click_FinalContinue.click(); 
		Thread.sleep(2000);
	}

	//Adult details are not added initially. Hence, User reaches to this activity again
	public void click_BookFlightButton2() throws InterruptedException {
		click_BookFlight.click(); 
		Thread.sleep(2000);
	}

	//Airlines Server error for selected Test Data(Travel Date, Random Passenger Details).........

}
