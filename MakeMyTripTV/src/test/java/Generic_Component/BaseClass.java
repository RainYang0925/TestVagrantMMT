package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static Process process;
	public static AndroidDriver driver;
	public static String folder;
	public static DateFormat dateformat;

	//Start server
	public static void Start_Server() throws IOException, InterruptedException{

		String Start_Server="C:\\Program Files\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";

		process = Runtime.getRuntime().exec(Start_Server);

		if(process!=null){
			System.out.println("Appium Server is Started");
		}else{
			System.out.println("NOT able to Start the Server");
		}

		Thread.sleep(12000);

	}


	public static void Initialize_app() throws MalformedURLException, InterruptedException{

		DesiredCapabilities capabilities= new DesiredCapabilities();

		//device details
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");

		//app details
		capabilities.setCapability("appPackage", "com.makemytrip");
		capabilities.setCapability("appActivity", "com.mmt.travel.app.home.ui.HomeActivity");

		//appium server details
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(8000);

	}


	//Stop server

	public static void Stop_Server() throws InterruptedException
	{
		Thread.sleep(4000);
		if(process!=null)
		{
			Thread.sleep(4000);

			process.destroy();						
			System.out.println("Stopped Appium Server");


		}

	}

	public static void implicit_Wait(){
		
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}
	
	/*
	 *Setting Format for snapshot file and creating folder name with file name for 
	 *each screenshot then copying the file into created 'folder' directory 
	 */
	
	public static void snapShot_MMT() throws IOException{
		
		folder = "screenshot";
        
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        dateformat=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        
        new File(folder).mkdir();
      
        String file_name=dateformat.format(new Date())+".png";
       
        FileUtils.copyFile(f, new File(folder + "/" + file_name));
	}
}