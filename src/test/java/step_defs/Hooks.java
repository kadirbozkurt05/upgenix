package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {
    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] data = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data,"image/png", scenario.getName());
        }

       Driver.close();
    }
}
