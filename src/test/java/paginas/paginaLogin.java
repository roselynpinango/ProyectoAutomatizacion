package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaLogin {
	WebDriver driver;
	
	/* Formulario izquierdo */
	@FindBy(xpath="//input[@id='email_create']")
	WebElement txtEmailAddress; 
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement btnCreateAnAccount;
	
	/* Formulario derecho */
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnSubmit;
	
	/* Buscador */
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement txtBuscador;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement btnBuscar;
	
	public paginaLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void llenarFormulario(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
	}
	
	public void clicOnSubmit() {
		btnSubmit.click();
	}
	
	public void llenarEmailAddress(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void clicOnCreateAnAccount() {
		btnCreateAnAccount.click();
	}
	
	public void llenarBuscador(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void clicOnBuscar() {
		btnBuscar.click();
	}
}
