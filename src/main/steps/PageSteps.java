package steps;

import io.cucumber.java.en.Given;
import static com.codeborne.selenide.Selenide.*;

public class PageSteps {
    @Given("Open Login page")
    public void loginPege(){
        open("https://google.com");
    }
}
