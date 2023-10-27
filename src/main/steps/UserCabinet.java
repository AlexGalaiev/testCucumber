import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UserCabinet {
    Faker fafeData = new Faker();
    @Given("Open platform")
    public void openPlatform() {
        open("https://magento.softwaretestingboard.com/");
        Configuration.browserSize = "1920x1080";
        $("#maincontent").shouldHave(Condition.visible);
    }
    @Then("I go to create user account form")
    public void iGoToCreateUserAccountForm() {
        $(By.linkText("Create an Account")).click();
        $(".form-create-account").shouldHave(Condition.visible);
    }

    @Then("I fill registration form with random credentials")
    public void iFillRegistrationFormWithRandomCredentials() {
        $("#firstname").setValue(fafeData.name().firstName());
        $("#lastname").setValue(fafeData.name().lastName());
        $("#email_address").setValue(fafeData.name().firstName()+fafeData.name().lastName()+"@i.com");
        $(".password #password").setValue("Test123!");
        $("#password-confirmation").setValue("Test123!");
        $(".submit").click();
        $("#maincontent").shouldHave(Condition.visible);
    }

    @Then("Should be text on page {string}")
    public void shouldBeTextOnPage(String string) {
        $(".message-success").getText().equals(string);
    }

    @Given("I login to platform by user {string}")
    public void iLoginToPlatformByUser(String arg0) {
        $("#email").setValue(arg0);
        $("[name='login[password]']").setValue("Test123!");
        $(".action-login").click();
        $("#maincontent").shouldHave(Condition.visible);
    }
}
