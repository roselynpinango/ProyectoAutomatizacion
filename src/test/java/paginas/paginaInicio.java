package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaInicio {
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Sign in']")
	WebElement lnkSignIn;
	
	public paginaInicio(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clicOnSignIn() {
		lnkSignIn.click();
	}
}
