package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", //Directorio de nuestros archivos .feature
        glue ="stepdefinitions", // Paquete donde tenemos nuestras clases
        plugin={"pretty","html:target/cucumber-reports"},
        tags = "@Un_Happy_Paths_03"
)
public class TestRunner {
}
