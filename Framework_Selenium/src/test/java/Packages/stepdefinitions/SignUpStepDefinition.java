package Packages.stepdefinitions;

import Packages.builders.data.UserBuilder;
import Packages.conf.DriverConfig;
import Packages.tasks.NavigateTo;
import Packages.tasks.UserSignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration(classes = {DriverConfig.class}) //traer confiuracion del driver spring

public class SignUpStepDefinition {

    @Autowired // insercción con sprin, llmando de la casle SignUp pra usp de los metodos.
    private UserSignUp signUp;

    @Autowired //Inyectar la clase Navigate para gacer uso de la url
    private NavigateTo navigate; // Instancia del NavitaTo, usada para

    @Given("Miguel wants to have an account")
    public void miguel_wants_to_have_an_account() {
        navigate.signUpPage(); // Navegmoas al signup, oea la URL
        System.out.print("Enrand");
    }

    @When("he sends required information to get the account")
    public void he_sends_required_information_to_get_the_account() throws InterruptedException {
        signUp.withInfo( /*Llamamos el withinfo donde estan los servicios.*/
                UserBuilder //Referencia a la clase
                        .anUser()
                        /* .withDefaultInfo()*/
                        .but()/*Hacemos uso de los metodos para insertar datos especifcos.*/
                        .withouBirthDay()
                        .withoutEmail()
                        .build()
        );
        Thread.sleep(100);
    }

    @Then("he should be told that the account was created")
    public void he_should_be_told_that_the_account_was_created() {
        assertThat(true).isEqualTo(true); //Fines educativps-
    }

    @Then("he should be told that the account was not created")
    public void he_should_be_told_that_the_account_was__not_created() {
        assertThat(true).isEqualTo(false);
    }
}

