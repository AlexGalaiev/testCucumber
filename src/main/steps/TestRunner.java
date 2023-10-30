
import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class TestRunner {

    @BeforeClass
    public static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 5000;
    }

}
