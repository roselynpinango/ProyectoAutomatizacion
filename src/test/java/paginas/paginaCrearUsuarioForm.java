package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.paginaManager;

public class paginaCrearUsuarioForm extends paginaManager {
	WebDriver driver;
	
	@FindBy(css="#customer_firstname")
	WebElement txtFirstName;
	
	@FindBy(id="id_gender2")
	WebElement radFemaleGender;
	
	@FindBy(id="id_gender1")
	WebElement radMaleGender;
	
	@FindBy(css="#customer_lastname")
	WebElement txtLastName;
	
	@FindBy(id="passwd")
	WebElement txtPassword;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement drpDay;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement drpMonth;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement drpYear;
	
	@FindBy(css="#newsletter")
	WebElement chkNewsletter;
	
	@FindBy(css="#optin")
	WebElement chkOption;
	
	@FindBy(css="#company")
	WebElement txtCompany;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement txtAddress1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement txtAddress2;
	
	@FindBy(css="#city")
	WebElement txtCity;
	
	@FindBy(css="#id_state")
	WebElement drpState;
	
	@FindBy(id="postcode")
	WebElement txtPostcode;
	
	@FindBy(xpath="//select[@id='id_country']")
	WebElement drpCountry;
	
	@FindBy(id="other")
	WebElement txtOther;
	
	@FindBy(id="phone")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement txtMobile;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement txtAlias;
	
	@FindBy(css="#submitAccount")
	WebElement btnSubmitAccount;
	
	public paginaCrearUsuarioForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void completarFormularioCrearUsuario(String firstName, 
												String gender, 
												String lastName,
												String password,
												String day,
												String month, 
												String year,
												String newsletter,
												String options,
												String company,
												String address1,
												String address2,
												String city,
												String state,
												String postcode,
												String country,
												String other, 
												String phone,
												String mobile,
												String alias) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(txtFirstName));
		txtFirstName.sendKeys(firstName);
		
		if (gender.equals("M")) {
			radMaleGender.click();
		} else {
			radFemaleGender.click();
		}
		
		txtLastName.sendKeys(lastName);
		txtPassword.sendKeys(password);
		
		this.selectByValueOn(drpDay, day);
		this.selectByValueOn(drpMonth, month);
		this.selectByValueOn(drpYear, year);
		
		/*
		Select selDay = new Select(drpDay);
		selDay.selectByValue(day);
		
		Select selMonth = new Select(drpMonth);
		selMonth.selectByValue(month);
		
		Select selYear = new Select(drpYear);
		selYear.selectByValue(year);
		*/
		if (newsletter.equals("true")) {
			chkNewsletter.click();
		}
		
		if (options.equals("true")) {
			chkOption.click();
		}
		
		txtCompany.sendKeys(company);
		txtAddress1.sendKeys(address1);
		txtAddress2.sendKeys(address2);
		txtCity.sendKeys(city);
		
		Select selState = new Select(drpState);
		selState.selectByValue(state);
		
		txtPostcode.sendKeys(postcode);
		
		Select selCountry = new Select(drpCountry);
		selCountry.selectByValue(country);
		
		txtOther.sendKeys(other);
		txtPhone.sendKeys(phone);
		txtMobile.sendKeys(mobile);
		
		txtAlias.clear();
		txtAlias.sendKeys(alias);
	}
	
	public void clicOnRegistrar() {
		btnSubmitAccount.click();
	}
}
