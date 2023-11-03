import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ProductCard {
    @Given("I go to page of product {string}")
    public void iGoToPageOfProduct(String productPage) {
        open(productPage);
        $(".base").shouldHave(Condition.visible);

    }
    @When("Users checks correct view of {string}")
    public void checkWhenUserClicksOnSizeCorrectSizeIsDisplays(String productSize) {
        Assert.assertEquals(productSize,
                $(".size .swatch-attribute-selected-option").getText());
        }
    @Given("User click on {string}")
    public void userClickOn(String arg0) {
        $(".size .swatch-attribute-options")
                .$(By.cssSelector("[option-label='"+arg0+"']"))
                .click();
    }

    @Given("User chose {string}")
    public void userChoos(String color) {
        $(".color .swatch-attribute-options")
                .$(By.cssSelector("[aria-label='"+color+"']"))
                .click();
    }

    @Then("User check what {string} is displayed")
    public void userCheckWhatIsDisplayed(String stringColor) {
        $(".color .swatch-attribute-selected-option")
                .shouldHave(Condition.text(stringColor));
    }
    @Then("Wishlist must be empty")
    public void wishlistMustBeEmpty() {
        try {
            SelenideElement itemField = $(By.xpath("//form[@class=\"form-wishlist-items\"]/preceding-sibling::div[1]/div[@class='pager']"));
            if (itemField.is(Condition.visible)){
                ElementsCollection deleteBtns = $$(".actions-secondary .delete");
                for(SelenideElement deleteBtn:deleteBtns){
                    deleteBtn.click();
                }
            }
        } catch (StaleElementReferenceException elementNotFound) {
            $("#wishlist-view-form").shouldHave(Condition.text("You have no items in your wish list."));
        }
    }

    @Then("I add product to wishlist")
    public void iAddProductToWishlist() {
        $(".product-addto-links .towishlist").click();
        $(".form-wishlist-items .product-item").shouldHave(Condition.visible);
    }

    @Given("I buy product with {string} {string} {string}")
    public void iBuyProductWith(String size, String color, String amount) {
        $("[option-label='"+color+"']").click();
        $("[option-tooltip-value='"+size+"']").click();
        $("#qty").clear();
        $("#qty").sendKeys(amount);
        $("#product-addtocart-button").click();
        $(".message-success").shouldHave(Condition.visible)
                .shouldHave(Condition.text("You added Breathe-Easy Tank to your "));
    }

    @And("I check minicard with preconditions {string} {string} {string} {string}")
    public void iCheckMinicardWithPreconditions(String size, String color, String amount, String price) {
        $(".showcart").scrollTo().click();
        SelenideElement miniCart = $("#minicart-content-wrapper");
        miniCart.shouldHave(Condition.visible);
        $(By.xpath("//ol[@class='minicart-items']//div[contains(@class, 'options')]")).click();
        $(By.xpath("//ol[@class='minicart-items']//dd[contains(@class, values)][1]"))
                .shouldHave(Condition.text(size));
        $(By.xpath("//ol[@class='minicart-items']//dd[contains(@class, values)][2]"))
                .shouldHave(Condition.text(color));
        miniCart.$(".count").shouldHave(Condition.text(amount));
        miniCart.$(".subtotal .price").shouldHave(Condition.text(price));
        $("#top-cart-btn-checkout").click();


    }
}
