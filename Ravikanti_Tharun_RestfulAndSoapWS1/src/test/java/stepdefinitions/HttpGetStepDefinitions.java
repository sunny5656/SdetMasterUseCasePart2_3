package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;



import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpGetStepDefinitions {
    private CloseableHttpClient httpClient;
    private HttpGet httpGet;
    private HttpResponse response;
    private int statusCode;

    @Given("I have an HTTP GET request")
    public void initializeHttpGetRequest() {
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet("https://petstore.swagger.io");
    }

    @When("I send the HTTP GET request")
    public void sendHttpGetRequest() {
        try {
            response = httpClient.execute(httpGet);
            statusCode = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should receive a response with status code {int}")
    public void verifyStatusCode(int expectedStatusCode) throws Exception {
        Assert.assertEquals(statusCode, expectedStatusCode, "Expected response code: " + expectedStatusCode + ", Actual response code: " + statusCode);
        httpClient.close();
    }
}
