package Packages.PageObjects;

import Packages.enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // //Spring Indicamos que sea un bean para ser utulizar la clase en el frame.
public class SignUpServices {

    @Autowired// Inyeccion de dependencia WebDriver directa desdde PageBase
    private WebDriver driver;

    @Autowired // Se encarga de crear la dependencia, ocea traer los objetos de la clase SignUPage
    private SignUpPageObject signUpPageObject;

    @Autowired //Inyectaamos la dependencia del Wired traida desde DriverConfid
    WebDriverWait wait;


    public void writeFirstName(String ReceivedName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.signUpPageObject.getFirstNameTextBox()));//EN espera del elemento, inyectado desde DriverConfig.
        this.signUpPageObject.getFirstNameTextBox().sendKeys(ReceivedName);
    }

    public void writerlastName(String ReceivedLastName) {
        this.signUpPageObject.getLastaName().sendKeys(ReceivedLastName);
    }

    public void writerEmailAddress(String ReceivedEmail) {
        this.signUpPageObject.getEmailAddress().sendKeys(ReceivedEmail);
    }

    public void writerPhone(String ReceivedPhone) {
        this.signUpPageObject.getPhone().sendKeys(ReceivedPhone);
    }

    private void SelectMale() {
        this.signUpPageObject.getGenderMale().click();
    }

    private void SelectFemale() {
        this.signUpPageObject.getGenderFemale().click();
    }

   /*public void SelectCountry(String ReceivedCountry) {
        new Select(this.signUpPageObject.getCountry()).selectByValue(ReceivedCountry);
    }*/

    public void SelectBithDay(String ReceivedDay) {
        new Select(this.signUpPageObject.getDateOBirthDay()).selectByValue(ReceivedDay);
    }

    public void SelectBirthMonth(String ReceivedMonth) {
        new Select(this.signUpPageObject.getGetDateOfBirtMonth()).selectByValue(ReceivedMonth);
    }

    public void SelectBirthYaer(String ReceivedYear) {
        new Select(this.signUpPageObject.getDateOfBirthYear()).selectByValue(ReceivedYear);
    }

    public void writerFirstPassword(String FirstPasswordReceived) {
        this.signUpPageObject.getPassword().sendKeys(FirstPasswordReceived);
    }

    public void writerComfirPassword(String ReceivedConfirmPassword) {
        this.signUpPageObject.getConfirmPassword().sendKeys(ReceivedConfirmPassword);
    }

    public void clickButtonAcepted() {
        this.signUpPageObject.getSubmit().click();
    }

    public void go(String url) {
        this.driver.get(url); //recbe url a navegar
    }

    public void selectGender(Gender gender){ //Seleccionar el gender
        if (gender == Gender.FeMale) {
            SelectFemale();
        } else
            SelectMale();
    }

}
