package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Generic_Component.BaseClass;
import PageObject_Component.PageObjectSearch;

/*
 * Driver Class 
 */

public class DriverComponent extends BaseClass{

	public static Logger log= Logger.getLogger(DriverComponent.class);
	SoftAssert sAssert= new SoftAssert();

	@Test
	public void TestAddCart() throws IOException, InterruptedException{
		
		Start_Server();
		//Thread.sleep(18000);
		Initialize_app();

		log.info("----------App Launched --------");

		PageObjectSearch BC_pob= new PageObjectSearch(driver);
		
		snapShot_MMT();
		implicit_Wait();
		
		log.info("----------Clicked on Flight Search--------");
		
		BC_pob.flight_search();
		snapShot_MMT();
		implicit_Wait();
		
		BC_pob.select_depCity();
		snapShot_MMT();
		implicit_Wait();
		
		BC_pob.enter_depCityName("Bangalore");
		implicit_Wait();
		BC_pob.select_searchedCity();

		/*
		 * ******************Searching and Entering 'To' City Name**************
		 */
		BC_pob.select_arrCity();
		snapShot_MMT();
		implicit_Wait();

		//City Edit Text WebElement declaration is already exist
		BC_pob.enter_arrCityName("Pune");
		implicit_Wait();
		BC_pob.select_searchedArrivalCity();
		

		/*
		 * Deaprture Date Selection, Here Assumed Date is 23rd Jan'17
		 * 
		 */
		BC_pob.departure_Date();
		implicit_Wait();
		BC_pob.click_depDate();

		implicit_Wait();
		BC_pob.click_depDateOK();
		implicit_Wait();
		
		/*
		 * Return Date selection, Here assumed Date is 25th Jan'17
		 * 
		 */

		BC_pob.returnDateSelection();
		implicit_Wait();
		BC_pob.click_returnDate();

		//We can still make a single method due to same id for OK Button in Calendar but I will go with unique
		implicit_Wait();
		BC_pob.click_returnDateOK();

		//Adult and Class selection
		BC_pob.select_AdultCnt();
		snapShot_MMT();

		//Taking adult count As 1
		BC_pob.adultCount_OK();

		//Class Category
		implicit_Wait();
		BC_pob.click_ClassType();
		
		//Assuming Economy Class is our Test Data
		BC_pob.click_ClassTypeSelected();

		//Search Flights
		implicit_Wait();
		BC_pob.search_Flights();
		snapShot_MMT();
		
		/*
		 * ----------------------------------------------------------------------
		 * Assuming default price selection among the search result is OK and
		 * Initiating Booking Process
		 * ----------------------------------------------------------------------
		 */
		implicit_Wait();
		BC_pob.booking_Init();

		/*
		 * --------------------------------------------------------------
		 * Assuming default Insurance selection is OK
		 * --------------------------------------------------------------
		 */
		implicit_Wait();
		BC_pob.click_ContinueBooking();
		snapShot_MMT();

		/*
		 * ----------------------------------------------------
		 * Adding Adult Details as following Test Data
		 * First Name: Raman
		 * Last Name : Hullur
		 * Gender: Male
		 * --------------------------------------------------------
		 */
		implicit_Wait();
		BC_pob.click_AddNewAdult();

		BC_pob.enter_FirstLastName("Raman", "Hullur");
		//Gender TD default: Male

		implicit_Wait();
		BC_pob.click_DoneButton();
		snapShot_MMT();
		
		BC_pob.click_BookFlightButton();
		snapShot_MMT();

		implicit_Wait();
		BC_pob.click_AgreeContinueButton();

		BC_pob.click_ContinuePriceButton();
		snapShot_MMT();
		
		//Adult details are not added initially. Hence, User reaches to this activity again
		BC_pob.click_BookFlightButton2();
		snapShot_MMT();

		//Airlines Server error for selected Test Data(Travel Date, Random Passenger Details).........

		Stop_Server();
		sAssert.assertAll();

	}
}
