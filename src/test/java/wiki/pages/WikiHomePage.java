package wiki.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Config;

public class WikiHomePage {

	@FindBy(xpath = "//*[@id=\"leo-top-menu\"]/ul/li/a/span")
	List<WebElement> menus;

	@FindBy(xpath = "//*[@id=\"leo-top-menu\"]/ul/li/div/div/div/div/div/ul/li/div/div/div/div/div/ul/li/a/span")
	List<WebElement> subMenus;
	
	@FindBy(id="search_query_top")

	WebElement searchItem;

	public WikiHomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void mouseHoverOnArticlesMenuAndClickOnSubMenu(String choixMenu, String choixSubMenu) {
		
		try {
			
	
		for (WebElement menu : menus) {

			if (menu.getText().contains(choixMenu)) {

				Config.actions = new Actions(Config.driver);

				Config.actions.moveToElement(menu).perform();

				for (WebElement subMenu : subMenus) {

					if (subMenu.getText().contains(choixSubMenu)) {

						subMenu.click();
						
						WebDriverWait wait = new WebDriverWait(Config.driver, 10);
						
						wait.until(ExpectedConditions.urlContains(choixSubMenu.toLowerCase()));
						
						
						break;

					}

				}

			}

		}
		
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}


	}

	public void searchItem(String item) {
		
		
		searchItem.sendKeys(item + Keys.ENTER);
		
		
	}
	
	
	
	

}
