package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumberReport.html", },
        // list all names.feature files
        features = {
                "src/test/resources/features/login.feature",
        },
        glue = {"steps"}

)
public class TestRunner {  }
