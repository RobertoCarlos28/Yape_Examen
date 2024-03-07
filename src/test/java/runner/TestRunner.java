package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(publish = true,
        features = "src/test/resources/features", //Directorio de nuestros archivos .feature
        glue ="stepdefinitions", // Paquete donde tenemos nuestras clases
        tags = "@TestBookingIntegracion",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class TestRunner {
}

