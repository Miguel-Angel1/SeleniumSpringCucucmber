package Packages.builders.data;

import Packages.enums.Gender;
import Packages.models.Users;

public class UserBuilder {
    private Users user;//Instacia de la clase users.

    private UserBuilder() {
        user = Users.builder().build();
    }

    public static UserBuilder anUser() {
        return new UserBuilder();//Retonrar estancia
    }

    public UserBuilder but() {
        return withDefaultInfo(); /*Este metodo se usa para cambiar valores*/
    }

    public UserBuilder withDefaultInfo() {
        this.user = Users.builder()  //Llena los daros usando el builder aplicado a la clase users
                .firstName("Miguel") /*Enviar información a las varibales del User.java*/
                .lastName("Castañeda")
                .email("miguel.macm.ca@gmail.com")
                .gender(Gender.Male)
                // .country("Colombia")
                .birthDay("10")
                .birthMonth("June")
                .birthYaer("1998")
                .phone("5540281625")
                .password("Admin12345H.*")
                .passwordComfirm("Admin12345H.*").build();
        return this;
    }

    //Ejemplo del uso del but, para insertar datos especificos
    public UserBuilder withoutEmail() {
        user.setEmail("");
        return this;
    }

    public UserBuilder withouBirthDay() {
        user.setBirthDay("");
        return this;
    }

    public Users build() {
        return this.user; //Devuelve el usaurio constriuido.
    }


}
