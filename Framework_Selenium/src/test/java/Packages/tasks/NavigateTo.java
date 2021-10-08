package Packages.tasks;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //Usar clase en cualquier Frame
public class NavigateTo {

    @Autowired //Traer el driver
    private WebDriver webDriver;

    @Value("${url}") //Tremos la URL del PageBase.
    private String url;

    public void signUpPage(){ //Navegar hacia el signUpPage
        this.webDriver.get(url);//obtener la url
    }
}
