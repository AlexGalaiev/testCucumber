package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import static com.codeborne.selenide.Selenide.*;

public class PageSteps {
    @Given("Open Login page")
    public void loginPege(){
        open("https://www.saucedemo.com/");
        $(".login-box").shouldHave(Condition.visible);
    }
}
