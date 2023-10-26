package steps;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateAccountForm {
    Faker fafeData = new Faker();
    @Given("Open paltform")
    public void loginPege(){
        open("https://magento.softwaretestingboard.com/");
        $("#maincontent").shouldHave(Condition.visible);
    }
    @Then("I go to create user accont form")
    public void createAccountForm(){
        $(By.linkText("Create an Account")).click();
        $(".form-create-account").shouldHave(Condition.visible);

    }
    @Then("I fill registartion form with random credentials")
    public void createRandomPerson(){
        $("#firstname").setValue(fafeData.name().firstName());
        $("#lastname").setValue(fafeData.name().lastName());
        $("#email_address").setValue(fafeData.name().firstName()+fafeData.name().lastName()+"@i.com");
        $(".password #password").setValue("Test123!");
        $("#password-confirmation").setValue("Test123!");
        $(".submit").click();
        $("#maincontent").shouldHave(Condition.visible);
    }
    @Then("Should be text on page {string}")
    public void shouldBeeText(String string){
        $(".message-success").getText().equals(string);
    }
}
