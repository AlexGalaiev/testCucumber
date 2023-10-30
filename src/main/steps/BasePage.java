import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    @Given("Open platform")
    public void openPlatformOnPage() {
        Configuration.browserSize ="1920x1080";
        open("https://magento.softwaretestingboard.com");
        $("#maincontent").shouldHave(Condition.visible);
    }
}
