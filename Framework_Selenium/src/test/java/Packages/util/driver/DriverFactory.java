package Packages.util.driver;
import Packages.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver get(Browser driveType) { //Usamos nuestro enum,
        if (Browser.chrome == driveType) { // Validamos que fue lo que estamos recibiendo
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe");
            return new ChromeDriver();
        }
        if (Browser.firefox == driveType) { // Si vamos a emplear este metodo descargar el driver de firefox
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/windows/geckodriver");
            return new FirefoxDriver();
        }
        throw new IllegalArgumentException("Driver not found");
    }
}
