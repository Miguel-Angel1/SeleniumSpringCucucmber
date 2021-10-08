package Packages.tasks;

import Packages.PageObjects.SignUpServices;
import Packages.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Usar en cualqueri cllase.
public class UserSignUp {

    @Autowired //Inyeccion de dependencias de las clases de SignUpServices
    private SignUpServices signUp;

    public void withInfo(Users user) { //Creamos un metodo para traer las variables del model Users y la instanciamos en user
        signUp.writeFirstName(user.getFirstName()); //Obetenmos los datos del
        signUp.writerlastName(user.getLastName());
        signUp.writerEmailAddress(user.getEmail());
        signUp.selectGender(user.getGender());
        /*signUp.SelectCountry(user.getCountry());*/
        signUp.SelectBithDay(user.getBirthDay());
        signUp.SelectBirthMonth(user.getBirthMonth());
        signUp.SelectBirthYaer(user.getBirthYaer());
        signUp.writerPhone(user.getPhone());
        signUp.writerFirstPassword(user.getPassword());
        signUp.writerComfirPassword(user.getPasswordComfirm());
        // signUp.clickButtonAcepted();
    }
}
//Recive objetos con valores y llena los campos con dichos campos