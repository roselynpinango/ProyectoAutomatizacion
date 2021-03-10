package Utilidades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paginaManager {
	public void clicOn(WebElement element) {
		element.click();
	}
	
	public void sendKeysOn(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void selectByValueOn(WebElement element, String value) {
		Select drp = new Select(element);
		drp.selectByValue(value);
	}
	
	public void waitFor(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
