package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Icone de pesquisa *Lupa
	@FindBy(id = "search-trigger")
	public WebElement ICON_SEARCH;
	
	//Input para preencher com a busca que deseja
	@FindBy(id = "global-search-input")
	public WebElement INPUT_SEARCH;
	
	//Botão "PROCURAR"
	@FindBy(xpath = "//*[contains(@class, 'c-search-box__button')]")
	public WebElement BTN_SEARCH;
	
	@FindBy(xpath = "//*[contains(@class, 'c-search-page__title--red')]")
	public WebElement PAGE_TITLE;
	
	public WebElement LocatorByText(String textToLocate) {
		
		String xpath = "//*[contains(text(),'"+textToLocate+"')]";
		
		return driver.findElement(By.xpath(xpath));
	}

}
