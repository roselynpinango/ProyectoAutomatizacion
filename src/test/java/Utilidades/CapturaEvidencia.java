package Utilidades;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CapturaEvidencia {
	public static void capturarPantallaEnDocumento(WebDriver driver, String nombreImagen, String directorioDestino) throws IOException {
		// Captura la pantalla actual
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Guarda la imagen en el directorio especificado
		File imageFile = new File(directorioDestino + "\\" + nombreImagen);
		FileUtils.copyFile(screen, imageFile);
	}
}
