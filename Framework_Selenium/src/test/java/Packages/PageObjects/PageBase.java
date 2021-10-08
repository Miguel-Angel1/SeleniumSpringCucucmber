package Packages.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Aarchiov que se puede usar en cualquier clase del frame
public class PageBase {
    protected WebDriver webDriver; //Acceso a la clase desde subclases
    @Autowired//yeccion de consttucrtor
    public PageBase(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
