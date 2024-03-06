package steps;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;


public class BookingStep {

    public RequestSpecification requestSpecification;
    public Response response;
    public final String BASE_URL ="https://restful-booker.herokuapp.com/";

    public void configuroEstado() {
        requestSpecification = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON);
    }

    public void configuroHeaders(DataTable dataTable) {
        List<Map<String,String>> featureHeadersInfo = dataTable.asMaps(String.class, String.class);
        requestSpecification = RestAssured
                .given()
                .header(dataTable.row(0).get(0),featureHeadersInfo.get(0).get(dataTable.row(0).get(0)))
                .log().all()
                .contentType(ContentType.JSON);
    }
    public void configuroHeadersUpdate(DataTable dataTable) {
        List<Map<String,String>> featureHeadersInfo = dataTable.asMaps(String.class, String.class);
        requestSpecification = RestAssured
                .given()
                .header(dataTable.row(0).get(0),featureHeadersInfo.get(0).get(dataTable.row(0).get(0)))
                .header(dataTable.row(0).get(1),featureHeadersInfo.get(0).get(dataTable.row(0).get(1)))
                .header(dataTable.row(0).get(2),featureHeadersInfo.get(0).get(dataTable.row(0).get(2)))
                .log().all()
                .contentType(ContentType.JSON);
    }
    public void configuroHeadersDelete(DataTable dataTable) {
        List<Map<String,String>> featureHeadersInfo = dataTable.asMaps(String.class, String.class);
        requestSpecification = RestAssured
                .given()
                .header(dataTable.row(0).get(0),featureHeadersInfo.get(0).get(dataTable.row(0).get(0)))
                .header(dataTable.row(0).get(1),featureHeadersInfo.get(0).get(dataTable.row(0).get(1)))
                .log().all()
                .contentType(ContentType.JSON);
    }
    public void configuroURL(String url) {
        response = requestSpecification
                .post(BASE_URL+url)
                .then()
                .log()
                .all().extract().response();
    }
    public void configuroGetURL(String url) {
        response = requestSpecification
                .get(BASE_URL+url)
                .then()
                .log()
                .all().extract().response();
    }

    public void configuroPutURL(String url) {
        response = requestSpecification
                .put(BASE_URL+url)
                .then()
                .log()
                .all().extract().response();
    }
    public void configuroPatchURL(String url) {
        response = requestSpecification
                .patch(BASE_URL+url)
                .then()
                .log()
                .all().extract().response();
    }
    public void configuroDeleteURL(String url) {
        response = requestSpecification
                .delete(BASE_URL+url)
                .then()
                .log()
                .all().extract().response();
    }
    public void configuroBodyRequest(String body,DataTable dataTable) throws IOException {
        byte[] inp= Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/java/request/json/" + body));
        String data=new String(inp);

        List<Map<String,String>> featureHeadersInfo = dataTable.asMaps(String.class, String.class);

        String param1= "{{" + dataTable.row(0).get(0) + "}}";
        String param2= "{{" + dataTable.row(0).get(1) + "}}";

        String parameters = data
                .replace(param1, featureHeadersInfo.get(0).get(dataTable.row(0).get(0)))
                .replace(param2, featureHeadersInfo.get(0).get(dataTable.row(0).get(1)));

        requestSpecification
                .body(parameters);
    }

    public void configuroBodyRequestCreate(String body,DataTable dataTable) throws IOException {
        byte[] inp= Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/java/request/json/" + body));
        String data=new String(inp);

        List<Map<String,String>> featureHeadersInfo = dataTable.asMaps(String.class, String.class);
        
        String parameters = data
                .replace("{{firstname}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(0)))
                .replace("{{lastname}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(1)))
                .replace("{{totalprice}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(2)))
                .replace("{{checkin}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(3)))
                .replace("{{checkout}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(4)))
                .replace("{{additionalneeds}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(5)));

        requestSpecification
                .body(parameters);
    }

    public void configuroBodyRequestCreateUH(String body,DataTable dataTable) throws IOException {
        byte[] inp= Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/java/request/json/" + body));
        String data=new String(inp);

        List<Map<String,String>> featureHeadersInfo = dataTable.asMaps(String.class, String.class);

        String parameters = data
                .replace("{{firstname}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(0)))
                .replace("{{totalprice}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(1)))
                .replace("{{checkin}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(2)))
                .replace("{{checkout}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(3)))
                .replace("{{additionalneeds}}", featureHeadersInfo.get(0).get(dataTable.row(0).get(4)));

        requestSpecification
                .body(parameters);
    }
    public void configuroCodRpta(String codResp) {
        response
                .then()
                .statusCode(Integer.parseInt(codResp));
    }
    public void validoLaRespuesta(String rpta) {
        response
                .then()
                .extract()
                .asString();

        Assert.assertEquals(response.asString(),rpta);
        System.out.println("La respuesta del servicio es:" +  response.asString());
    }

    public void validoId(String id) {
        response
                .then()
                .body(id,equalTo(id));
    }
    public void configuroQueryParams(DataTable dataTable) {
        List<Map<String,String>> featureHeadersInfo = dataTable.asMaps(String.class, String.class);
        requestSpecification = RestAssured
                .given()
                .queryParam(dataTable.row(0).get(0),featureHeadersInfo.get(0).get(dataTable.row(0).get(0)))
                .queryParam(dataTable.row(0).get(1),featureHeadersInfo.get(0).get(dataTable.row(0).get(1)))
                .log().all();
    }

    public void configuroAPI() {
        requestSpecification = RestAssured
                .given()
                .log().all();
    }
    public void configuroParametros(DataTable dataTable) {
        List<Map<String,String>> featureHeadersInfo = dataTable.asMaps(String.class, String.class);

        System.out.println("AAA" + featureHeadersInfo.get(0).get(dataTable.row(0).get(0)));
        requestSpecification
                .pathParam(dataTable.row(0).get(0),featureHeadersInfo.get(0).get(dataTable.row(0).get(0)))
                .basePath("{featureHeadersInfo.get(0).get(dataTable.row(0).get(0))}")
                .log().all();
    }
}
