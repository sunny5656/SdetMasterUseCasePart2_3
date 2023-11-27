package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpPostStepDefinitions {
    private CloseableHttpClient httpClient;
    private HttpPost httpPost;
    private HttpResponse response;
    private int statusCode;

    @Given("I have an HTTP post request")
    public void initializeHttpPostRequest() {
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost("https://petstore.swagger.io/v2/pet"); // Replace with your POST endpoint URL
    }

    @When("I send the HTTP post request")
    public void sendHttpPostRequest() {
        try {
            // Create a request payload (e.g., JSON or XML) and set it in the entity of the POST request.
            String requestPayload =  "{\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>\\n\" +\r\n"
                    + "                                \"<Pet>\\n\" +\r\n"
                    + "                                \"    <id>0</id>\\n\" +\r\n"
                    + "                                \"    <Category>\\n\" +\r\n"
                    + "                                \"        <id>0</id>\\n\" +\r\n"
                    + "                                \"        <name>string</name>\\n\" +\r\n"
                    + "                                \"    </Category>\\n\" +\r\n"
                    + "                                \"    <name>doggie</name>\\n\" +\r\n"
                    + "                                \"    <photoUrls>\\n\" +\r\n"
                    + "                                \"        <photoUrl>string</photoUrl>\\n\" +\r\n"
                    + "                                \"    </photoUrls>\\n\" +\r\n"
                    + "                                \"    <tags>\\n\" +\r\n"
                    + "                                \"        <Tag>\\n\" +\r\n"
                    + "                                \"            <id>0</id>\\n\" +\r\n"
                    + "                                \"            <name>string</name>\\n\" +\r\n"
                    + "                                \"        </Tag>\\n\" +\r\n"
                    + "                                \"    </tags>\\n\" +\r\n"
                    + "                                \"    <status>available</status>\\n\" +\r\n"
                    + "                                \"</Pet>\"}";
            httpPost.setEntity(new StringEntity(requestPayload));

            response = httpClient.execute(httpPost);
            statusCode = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I will receive a response with status code {int}")
    public void verifyCode(int expectedStatusCode) throws Exception {
        Assert.assertEquals(statusCode, expectedStatusCode, "Expected response code: " + expectedStatusCode + ", Actual response code: " + statusCode);
        httpClient.close();
    }
}
