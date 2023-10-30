import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ProductCard {
    @Given("I go to page of product {string}")
    public void iGoToPageOfProduct(String productPage) {
        open(productPage);
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
}
