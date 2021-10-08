package Packages.conf;

import Packages.enums.Browser;
import Packages.util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;

@Configuration //Spirng, se encarga de deifinir la clase coomo una clase de configuracion para el Frame
@ComponentScan(basePackages = "Packages") // escaneo de todas las clases para el uso de sprint
@PropertySource("classpath:/application-${enviroment:dev}.properties") /*Properies que inyectara en los values los elementos, pero  valida
en que ambiente corre
    *Si corre en Dev se debe de correr de la siguiente manera: mvn clean test -Denviroment=dev
    *Si corre en prod debe de ser de la siguiente manera:  mvn clean test -Denviroment=prod
Para esto se crean 2 arhivos properties .Si no se indica el valor por defecto corre en dev. :dev
*/
public class DriverConfig {

    //Los value son inyecytados por el arhcivo application-dev.properties esto da mayor configuración.
    @Value("${driver.type}") //Spring, inyectoado a traves de un aplication properties
    private Browser driverType; //Traer el enum

    @Value("${element.wait.timeout.seconds}") //Metodo del timeout, trae los datos del application-dev.properties
    private int webDriverWaitTimeOut;//

    @Bean//Uso de bean en spring
    public WebDriver webDriver() { //Meotodo para el uso del diferente navegador.
        return DriverFactory.get(driverType); //Envua a la clase DriverFactory el navegador a usar, este viene de archivo properties
    }

    @Bean //Uso de spring
    public WebDriverWait waitFor() {
        return new WebDriverWait(webDriver(), Duration.ofSeconds(webDriverWaitTimeOut));// Tiempo de espera de time out, metodo del tiemeout, el cual esta
        //Configurado en el properties
    }
}