package Packages.util.reporting;


public enum TakesScreenshotCodition {
    everyStep, //Cada step
    failingScenario, //Cuando fallo el escenario
    endOfScenario, // Al final del escenario
    none
}
