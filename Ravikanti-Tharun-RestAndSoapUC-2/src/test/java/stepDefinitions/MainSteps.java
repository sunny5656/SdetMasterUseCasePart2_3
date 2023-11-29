package stepDefinitions;

import com.sdet.labs.Restful_Web_Services;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.testng.Assert.assertEquals;

public class MainSteps {

    static Integer statusCode;

    @Given("Json Place Holder site")
    public void json_place_holder_site() {
        Restful_Web_Services.setup();
    }

    @When("Rest Assured Request is {string}")
    public void rest_assured_request_is(String requestType) {
        switch (requestType.toLowerCase()) {
            case "get":
                statusCode = Restful_Web_Services.GetRequestStatusCode();
                break;
            case "put":
                statusCode = Restful_Web_Services.PutRequestStatusCode();
                break;
            case "post":
                statusCode = Restful_Web_Services.PostRequestStatusCode();
                break;
            case "patch":
                statusCode = Restful_Web_Services.PatchRequestStatusCode();
                break;
            case "delete":
                statusCode = Restful_Web_Services.DeleteRequestStatusCode();
                break;
            default:
                throw new IllegalArgumentException("Invalid request type: " + requestType);
        }
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer expectedCode) {
        assertEquals(statusCode, expectedCode, "Status code mismatch");
    }
}
