package Packages.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class PhotographerHook {
    @Autowired//Inyecion de dependencias para el driver
    private WebDriver driver;

    @Value("${take.screenshot.condition:none}") //Meotod para llamara los diferentes fromas de tomas screenshot
    private TakesScreenshotCodition takesScreenshotCondition;

    // ---------------- Metodos para Screenshot dependiendo el escenario ---------------
    @After //Al final de la ejecucion se llamada este metodo (Cucumber// )
    public void takeScreenShotAfterScenario(Scenario scenario) {
        //Cada escenario
        if (TakesScreenshotCodition.everyStep == takesScreenshotCondition) {
            takeScreen(scenario); //lllamanos al metodo takeScreen y pasamos la variable.
        }
    }

    @AfterStep //Despues de cada estep
    public void takeScreenShotAfterEveryStep(Scenario scenario) {
        //Cada step
        if (TakesScreenshotCodition.everyStep == takesScreenshotCondition) {
            takeScreen(scenario); //lllamanos al metodo takeScreen y pasamos la variable.
        }
    }

    @After //Cuando falla el escenario.
    public void takeScreenShotAfterFailingScenario(Scenario scenario) {
        if (scenario.isFailed() && TakesScreenshotCodition.failingScenario == takesScreenshotCondition) {
            takeScreen(scenario);
        }
    }

    public void takeScreen(Scenario scenario) {
        //Metodo para Tomar screnshot, trae la variable de configuracion
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", UUID.randomUUID().toString());
        } catch (WebDriverException wde) {
            System.out.println("Error al tomar screenshot" + wde.getMessage());
        }
    }

}
