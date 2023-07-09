package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Config {

	public static WebDriver driver;

	public static Actions actions;

	public static void confDriver() {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");

	}
	
	
	
	
	public static void attente(long s) {
		
		driver.manage().timeouts().implicitlyWait(s, TimeUnit.SECONDS);
		
	}
	
	
	public static void maximise() {
		
		
		driver.manage().window().maximize();
		
		
	}
	
	

}
