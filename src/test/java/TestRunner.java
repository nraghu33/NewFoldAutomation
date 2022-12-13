import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
        },
        glue = {"steps"},
        features = "/Users/joyashree/Documents/NewFoldLatest/automation/src/test/resources/features"
)


public class TestRunner {
}
