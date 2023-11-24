package com.masterUsecse.soapUI;



import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import static org.testng.Assert.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class AssertionTestng {
    @Test
    public void testHttpGet() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://petstore.swagger.io/");

        try {
            HttpResponse response = httpClient.execute(httpGet);

            // Assert the response code is 200 (OK)
            int statusCode = response.getStatusLine().getStatusCode();
          AssertJUnit.assertEquals(statusCode, 200);

            // Close the HttpClient when done.
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public class HttpPostTest {
        @Test
        public void testPostRequest() {
            // Call the function to perform the HTTP POST and assertion
            performHttpPostAndAssert();
        }

        // Create a separate function for the HTTP POST and assertion
        private void performHttpPostAndAssert() {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("https://petstore.swagger.io/v2/pet");

            try {
                // Set the XML request body
                String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                    "<Pet>\n" +
                                    "    <id>0</id>\n" +
                                    "    <Category>\n" +
                                    "        <id>0</id>\n" +
                                    "        <name>string</name>\n" +
                                    "    </Category>\n" +
                                    "    <name>doggie</name>\n" +
                                    "    <photoUrls>\n" +
                                    "        <photoUrl>string</photoUrl>\n" +
                                    "    </photoUrls>\n" +
                                    "    <tags>\n" +
                                    "        <Tag>\n" +
                                    "            <id>0</id>\n" +
                                    "            <name>string</name>\n" +
                                    "        </Tag>\n" +
                                    "    </tags>\n" +
                                    "    <status>available</status>\n" +
                                    "</Pet>";

                // Set the request body
                StringEntity entity = new StringEntity(requestBody, "UTF-8");
                entity.setContentType("application/xml");
                httpPost.setEntity(entity);

                // Execute the POST request
                HttpResponse response = httpClient.execute(httpPost);

                // Assert the actual and expected response
                int statusCode = response.getStatusLine().getStatusCode();
                String expectedResponse = "200";
                AssertJUnit.assertEquals(statusCode, Integer.parseInt(expectedResponse));

                // Close the HttpClient when done.
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("POST request failed");
            }
        }
    }

}


