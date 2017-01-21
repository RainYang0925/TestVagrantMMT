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
		
		/*Explicitwait(BC_pob.Search_txtbox, 25);
		BC_pob.Enter_Searchtxt(Search_item);

		Explicitwait(BC_pob.Add_btn, 25);
		BC_pob.Click_Addbtn();

		Explicitwait(BC_pob.Cart_img, 25);
		BC_pob.Click_Cartimg();

		Explicitwait(BC_pob.AddCart_msg, 25);
		String Actual_Result = BC_pob.getAddCartmsg();

		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is " +Actual_Result + " Expected Result is " +Exp_Result);
			Snapshot1(TC_ID, Order);
		}
		else
		{

			log.info("Failes as Actual Result is " +Actual_Result + " Expected Result is " +Exp_Result);
			sAssert.fail("Failed as Actual Result is " +Actual_Result + " Expected Result is " +Exp_Result);
			Snapshot1(TC_ID, Order);
		}
*/

		Stop_Server();
		sAssert.assertAll();

	}
}
