package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_defs",
        dryRun = false,
        tags = "@logout",
        plugin = {"html:target/CucumberReport.html",
                   "json:target/CucumberReport.json",
                   "rerun:target/rerun.txt"}
)

public class CukesRunner {
}
