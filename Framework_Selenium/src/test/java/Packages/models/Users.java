package Packages.models;
import Packages.enums.Gender;
import lombok.Builder;
import lombok.Data;

@Data //Lombok
@Builder//Lombok
public class Users {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    //private String country;
    private String birthDay;
    private String birthMonth;
    private String birthYaer;
    private String phone;
    private String password;
    private String passwordComfirm;
}
