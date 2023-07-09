package helper;

import org.junit.Assert;

public class WikiAssertions {
	
	
	
	
	
	
	public static void assertURLContains(String textInURL) {
		
	String actualURL =	Config.driver.getCurrentUrl();
		
		Assert.assertTrue(actualURL.contains(textInURL));
		
		
	}
	
	
	

}
