package com.sdet.labs;

import io.restassured.RestAssured;

public class Restful_Web_Services {
	
	static int StatusCode;


    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    public static int GetRequestStatusCode() {
    	
    	StatusCode = RestAssured.given().when().get("/posts/1").getStatusCode();        
        return StatusCode;
    }

    public static int PostRequestStatusCode() {
        String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        StatusCode = RestAssured.given().header("Content-Type", "application/json").body(requestBody).when().post("/posts").getStatusCode();
        return StatusCode;
    }

    public static int PutRequestStatusCode() {
        String requestBody = "{ \"id\": 1, \"title\": \"updated foo\", \"body\": \"updated bar\", \"userId\": 1 }";

        StatusCode = RestAssured.given().header("Content-Type", "application/json").body(requestBody).when().put("/posts/1").getStatusCode();
        return StatusCode;
    }

    public static int PatchRequestStatusCode() {
        String requestBody = "{ \"title\": \"patched foo\" }";

        StatusCode = RestAssured.given().header("Content-Type", "application/json").body(requestBody).when().patch("/posts/1").getStatusCode();
        return StatusCode;
    }

    public static int DeleteRequestStatusCode() {
    	StatusCode = RestAssured.given().when().delete("/posts/1").getStatusCode();
        return StatusCode;
    }

}
