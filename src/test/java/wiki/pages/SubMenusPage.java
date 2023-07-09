package wiki.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Config;

public class SubMenusPage {

	@FindBy(xpath = "//*[@id=\"product_list\"]/div/div/div/h4/a")
	List<WebElement> products;

	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")

	WebElement addToCard;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[5]/a/span")
	WebElement commander;

	@FindBy(xpath = "//*[@id=\"cart\"]/div[1]/div[2]/a/span/span[1]")
	WebElement panier;

	@FindBy(xpath = "//*[@id=\"cart\"]/div[2]/div/div/dl/dt/div/div/a")
	WebElement panierContent;

	@FindBy(xpath = "//*[@id=\"pQuantityAvailable\"]/span")
	WebElement availibility;

	@FindBy(id = "selectProductSort")

	WebElement triProductSelect;

	@FindBy(xpath = "//*[@id=\"product_list\"]/div/div/div/div/div/span/span")
	List<WebElement> availibilitiesStatusForEachProduct;

	public SubMenusPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void clickAndShopProductOnStockByName(String productName) {

		try {

			for (WebElement product : products) {

				if (product.getText().contains(productName)) {

					product.click();

					Assert.assertTrue(" The Product is not on stock   ! ", availibility.getText().equals("En stock"));

					addToCard.click();

					WebDriverWait wait = new WebDriverWait(Config.driver, 10);

					wait.until(ExpectedConditions.elementToBeClickable(commander));

					commander.click();

					Config.actions.moveToElement(panier).perform();

					Assert.assertTrue(panierContent.getText().contains(productName));

				}

			}

		} catch (StaleElementReferenceException e)

		{
		}

	}

	public void triProductSortBy(String sortTri) {

		Select select = new Select(triProductSelect);

		select.selectByVisibleText(sortTri);

	}

	public void verifyTriStockFontionnalites() {


		for (WebElement availibilitieStatus : availibilitiesStatusForEachProduct) {

			Assert.assertTrue(" Attention ! Probleme de tri en Stock, il y a des produits qui ne sont pas en Stock qui sont affichés  ",   availibilitieStatus.getText().equals("En Stock"));

		}

	}

}
