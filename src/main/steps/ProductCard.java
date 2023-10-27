import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductCard {
    @Given("I go to page of product")
    public void iGoToPageOfProduct() {
        open("https://magento.softwaretestingboard.com/breathe-easy-tank.html");
        $(".fotorama-item").shouldHave(Condition.visible);

    }
    @When("Users checks correct view of {string}")
    public void checkWhenUserClicksOnSizeCorrectSizeIsDisplays(String productSize) {
        Assert.assertEquals(productSize,
                $(".size .swatch-attribute-selected-option").getText());
        }
    @Given("User click on {string}")
    public void userClickOn(String arg0) {
        $(".size .swatch-attribute-options")
                .$("//*[contains(text(), '" + arg0 + "')]")
                .click();
    }
}
