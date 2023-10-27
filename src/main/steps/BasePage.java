import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    @Given("Open platform on page {string}")
    public void openPlatformOnPage(String url) {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://magento.softwaretestingboard.com/";
        open("url");
    }
}
