package Utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetnetSeleniumUtil {
	WebDriver driver;
	WebDriverWait wait;
	FluentWait<WebDriver> fWait;
	
	private final long TIME_WAIT_IN_SECONDS = 30; 
	
	public GetnetSeleniumUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIME_WAIT_IN_SECONDS);
		fWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(TIME_WAIT_IN_SECONDS))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
	}
	
	protected void AbrirSite(String link) {
		driver.get(link);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIME_WAIT_IN_SECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TIME_WAIT_IN_SECONDS, TimeUnit.SECONDS);
		try {
			Thread.sleep(1600);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	protected void ClicarBotao(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	protected void PreencherCampo(WebElement element, String texto) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(texto);
	}
	
	protected String RetornarTexto(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	protected void FecharDriver() {
		driver.close();
	}
}
