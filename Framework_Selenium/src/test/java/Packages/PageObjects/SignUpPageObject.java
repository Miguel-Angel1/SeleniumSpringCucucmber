package Packages.PageObjects;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Spring Indicamos que sea un bean para ser utulizar la clase en el frame.

@Getter //Uso de la dependencia lombok para los meotodos set y get de
// los elementos Web
public class SignUpPageObject extends PageBase {//Extendemos a la calse Paga Base
    @Autowired //Spring: Inyectamos la dependencia del driver, esta veiene del DriverConf
    public SignUpPageObject(WebDriver driver) {
     super(driver); //Llamamso el constructor de la deendecia PageBase
    }

    @FindBy(xpath = "//input[@ng-model='FirstName']")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@ng-model='LastName']")
    private WebElement lastaName;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phone;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement genderFemale;

    @FindBy(id = "countries")
    private WebElement country;

    @FindBy(id = "yearbox")
    private WebElement dateOfBirthYear;

    @FindBy(xpath = "//select[@ng-model='monthbox']")
    private WebElement getDateOfBirtMonth;

    @FindBy(id = "daybox")
    private WebElement dateOBirthDay;

    @FindBy(id = "firstpassword")
    private WebElement password;

    @FindBy(id = "secondpassword")
    private WebElement confirmPassword;

    @FindBy(id = "submitbtn")
    private WebElement submit;

    //Para crear los get y set hacemos uso de una
    //dependencia, en POM llamada lombok
}
