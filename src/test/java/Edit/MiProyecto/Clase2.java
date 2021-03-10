package Edit.MiProyecto;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2 {
	@Test
	public void clase2_E1() {
		// Otra forma de comentar en Java
		/* Puedo comentar asi en Java*/
		
		/* Configurar donde esta nuestro ChromeDriver */
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\BairesDev\\eclipse-workspace\\MiProyecto\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "..\\MiProyecto\\Drivers\\chromedriver.exe");
		
		/* Instanciar el objeto WebDriver */
		WebDriver driver = new ChromeDriver();
		
		/* Abrir el navegador Chrome en la página Selenium.dev */
		driver.get("https://www.selenium.dev/");
		
		/* Cerrar el navegador */
		//driver.close();
	}
	
	
	@Test
	public void clase2_E2() {
		/* Configurar donde esta nuestro ChromeDriver */
		System.setProperty("webdriver.gecko.driver", "..\\MiProyecto\\Drivers\\geckodriver.exe");
		
		/* Instanciar el objeto WebDriver */
		WebDriver driver = new FirefoxDriver();
		
		/* Abrir el navegador Chrome en la página Selenium.dev */
		driver.get("https://www.selenium.dev/");
		
		driver.manage().window().maximize();
		
		/* Cerrar el navegador */
		//driver.close();
	}
	
	@Test
	public void clase2_E3() {
		/* Configurar donde esta nuestro ChromeDriver */
		System.setProperty("webdriver.chrome.driver", "..\\MiProyecto\\Drivers\\chromedriver.exe");
		
		/* Instanciar el objeto WebDriver */
		WebDriver driver = new ChromeDriver();
		
		/* Abrir el navegador Chrome en la página Selenium.dev */
		driver.get("https://www.selenium.dev/");
		
		/* Identificar el campo de texto buscador */
		WebElement buscador = driver.findElement(By.id("gsc-i-id1"));
		
		/* Ingresar un valor en buscador */
		buscador.sendKeys("Java");
		
		/* Simular la tecla ENTER*/
		buscador.sendKeys(Keys.ENTER);
		
		/* Cerrar el navegador */
		//driver.close();
	}
}
