import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UserCabinet {
    Faker fafeData = new Faker();
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
        $(".panel .authorization-link").click();
        $(".login-container .block-customer-login").shouldHave(Condition.visible);
        $("#email").setValue(arg0);
        $("[name='login[password]']").setValue("Test123!");
        $(".actions-toolbar .login").click();
        $("#maincontent").shouldHave(Condition.visible);
    }

    @And("Next string must displayed {string}")
    public void nextStringMustDisplayed(String stringValue) {
        $(".panel .logged-in")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(stringValue));
    }

    @Given("I go to My Account and switch to My Wishlist")
    public void iGoToMyAccountAndSwitchToMyWishlist() {
        $(".panel .header .customer-welcome").click();
        $(".active .wishlist").click();
        $(".page-title-wrapper").shouldHave(Condition.visible);
    }

    @And("I check products in Wishlist")
    public void iCheckProductsInWishlist() {
        $(".form-wishlist-items .product-item").shouldHave(Condition.visible);

        $(".product-item-details .delete").click();
    }
}
