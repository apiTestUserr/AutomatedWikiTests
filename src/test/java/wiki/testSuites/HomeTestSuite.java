package wiki.testSuites;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import helper.Config;
import wiki.pages.SubMenusPage;
import wiki.pages.WikiHomePage;

public class HomeTestSuite {

	WikiHomePage home;

	SubMenusPage subMenuPage;

	@Before

	public void init() {

		Config.confDriver();

		Config.driver = new ChromeDriver();

		Config.driver.get("https://www.wiki.tn/");

		Config.maximise();

		home = new WikiHomePage(Config.driver);
		
		Config.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test

	public void serachProduct() {

		home.searchItem("MAC");

	}

	@Test
	public void shopProductFromHome() {

		home.mouseHoverOnArticlesMenuAndClickOnSubMenu("Impression", "Papier");

		subMenuPage = new SubMenusPage(Config.driver);

		
		subMenuPage.triProductSortBy("En Stock");
		

		subMenuPage.clickAndShopProductOnStockByName("Papier Rame Fabriano A4 80 g");
		

	}
	
	@Test
	public void triProductOnStock() {
		
		home.mouseHoverOnArticlesMenuAndClickOnSubMenu("Impression", "Papier");

		subMenuPage = new SubMenusPage(Config.driver);
		
		subMenuPage.triProductSortBy("En Stock");
		
		subMenuPage.verifyTriStockFontionnalites();
		
	}
	

}
