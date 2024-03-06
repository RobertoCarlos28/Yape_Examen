package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import steps.BookingStep;

import java.io.IOException;

public class BookingStepDefinition {
    @Steps
    BookingStep bookingStep = new BookingStep();

    @Dado("Tengo que validar la comprobacion de estado")
    public void tengoQueValidarLaComprobacionDeEstado() {
        bookingStep.configuroEstado();
    }

    @Cuando("configuro la url get {string}")
    public void configuroLaUrlGet(String url) {
        bookingStep.configuroGetURL(url);
    }

    @Entonces("el codigo de respuesta es {string}")
    public void elCodigoDeRespuesta(String codResp) {
        bookingStep.configuroCodRpta(codResp);
    }

    @Cuando("configuro body request create {string}")
    public void configuroBodyRequestCreate(String body, DataTable dataTable) throws IOException {
        bookingStep.configuroBodyRequestCreate(body,dataTable);
    }

    @Y("valido la respuesta de la api {string}")
    public void validoLaRespuestaDeLaAPi(String rpta) {
        bookingStep.validoLaRespuesta(rpta);
    }

    @Dado("configuro los headers")
    public void configuroLosHeaders(DataTable dataTable) {
        bookingStep.configuroHeaders(dataTable);
    }

    @Cuando("configuro body request {string}")
    public void configuroBodyRequest(String body,DataTable dataTable) throws IOException {
        bookingStep.configuroBodyRequest(body,dataTable);
    }

    @Y("configuro la url {string}")
    public void configuroLaUrl(String url) {
        bookingStep.configuroURL(url);
    }

    @Cuando("configuro los query params")
    public void configuroLosQueryParams(DataTable dataTable) {
        bookingStep.configuroQueryParams(dataTable);
    }

    @Y("configuro el api")
    public void configuroElApi() {
        bookingStep.configuroAPI();
    }

    @Y("configuro los parametros")
    public void configuroParametros(DataTable dataTable) {
        bookingStep.configuroParametros(dataTable);
    }

    @Y("configuro la url put {string}")
    public void configuroLaUrlPut(String url) {
        bookingStep.configuroPutURL(url);
    }

    @Cuando("configuro los headers update")
    public void configuroLosHeadersUpdate(DataTable dataTable) {
        bookingStep.configuroHeadersUpdate(dataTable);
    }

    @Y("configuro la url patch {string}")
    public void configuroLaUrlPatch(String url) {
        bookingStep.configuroPatchURL(url);
    }

    @Cuando("configuro los headers delete")
    public void configuroLosHeadersDelete(DataTable dataTable) {
        bookingStep.configuroHeadersDelete(dataTable);
    }

    @Y("configuro la url delete {string}")
    public void configuroLaUrlDelete(String url) {
        bookingStep.configuroDeleteURL(url);
    }

    @Y("valido el response {string}")
    public void validoElResponse(String id) {
        bookingStep.validoId(id);
    }

    @Y("configuro body no envio el lastname en el request {string}")
    public void configuroBodyNoEnvioElLastnameEnElRequest(String body, DataTable dataTable) throws IOException{
        bookingStep.configuroBodyRequestCreateUH(body,dataTable);
    }
}
