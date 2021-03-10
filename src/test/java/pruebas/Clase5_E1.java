package pruebas;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
import Utilidades.DatosExcel;
import paginas.paginaCrearUsuarioForm;
import paginas.paginaInicio;
import paginas.paginaLogin;

public class Clase5_E1 {
	WebDriver driver; 
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\MiProyecto\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
	}
	
	@BeforeTest
	public void irURL() {
		driver.get("http://automationpractice.com");	
	}
	
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProvider="Datos Login", priority=0)
	public void login(String email, String password) {
		/* Hacer clic en Sign In*/
		paginaInicio inicio = new paginaInicio(driver);
		inicio.clicOnSignIn();
		
		/* Completar formulario de login */
		paginaLogin login = new paginaLogin(driver);
		login.llenarFormulario(email, password);
		login.clicOnSubmit();
	}
	
	@Test(priority=1)
	public void createAnAccount() throws IOException, InterruptedException {
		/* Simplificar la captura de evidencias, guardando la imagen en un directorio */
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "paginaInicio.png", "..\\MiProyecto\\Evidencias");
		
		/* Hacer clic en Sign In*/
		paginaInicio inicio = new paginaInicio(driver);
		inicio.clicOnSignIn();
		
		/* Simplificar la captura de evidencias, guardando la imagen en un directorio */
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "clicEnSignIn.png", "..\\MiProyecto\\Evidencias");
		
		/* Completar el correo */
		paginaLogin login = new paginaLogin(driver);
		login.llenarEmailAddress("correo461@gmail.com");
		login.clicOnCreateAnAccount();
		
		/* Simplificar la captura de evidencias, guardando la imagen en un directorio */
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "LuegoDeIngresarCorreo.png", "..\\MiProyecto\\Evidencias");
		
		/* Tarea: Completar el formulario */
		paginaCrearUsuarioForm form = new paginaCrearUsuarioForm(driver);
		form.completarFormularioCrearUsuario("Andreina", "F", "Castro", "123456", "18", "6", "1990", 
											"true", "true", "Movistar", "Avenida Paseo Colón", "3467, Piso 10 - B", 
											"Miami", "10", "33215", "21", "Esto es una prueba automatizada", 
											"(001)-123-45678", "(001)-789-45678", "Trabajo");
		
		/* Simplificar la captura de evidencias, guardando la imagen en un directorio */
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "formularioLleno.png", "..\\MiProyecto\\Evidencias");
		
		form.clicOnRegistrar();		
		
		/* Simplificar la captura de evidencias, guardando la imagen en un directorio */
		CapturaEvidencia.capturarPantallaEnDocumento(driver, "luegoDelClicEnRegistrar.png", "..\\MiProyecto\\Evidencias");
	}
	
	@Test(priority=0)
	public void buscar() {
		/* Hacer clic en Sign In*/
		paginaInicio inicio = new paginaInicio(driver);
		inicio.clicOnSignIn();
		
		/* Buscar palabra */
		paginaLogin login = new paginaLogin(driver);
		login.llenarBuscador("skirt");
		login.clicOnBuscar();
	}
	
	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de Prueba");
	}
	
	@AfterTest
	public void cierre() {
		//driver.close();
	}
	
	@AfterSuite
	public void finSuitePruebas() {
		System.out.println("Fin Suite de Pruebas");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() throws Exception {
		return DatosExcel.leerExcel("..\\MiProyecto\\Datos\\DatosLogin.xlsx", "Hoja1");
	}
	
}
