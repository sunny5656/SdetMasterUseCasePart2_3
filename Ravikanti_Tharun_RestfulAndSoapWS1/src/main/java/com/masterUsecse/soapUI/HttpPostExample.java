package com.masterUsecse.soapUI;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpPostExample {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://petstore.swagger.io/v2/pet");

        try {
            // Set the XML request body
            String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<Pet>\n" +
                                "	<id>0</id>\n" +
                                "	<Category>\n" +
                                "		<id>0</id>\n" +
                                "		<name>string</name>\n" +
                                "	</Category>\n" +
                                "	<name>doggie</name>\n" +
                                "	<photoUrls>\n" +
                                "		<photoUrl>string</photoUrl>\n" +
                                "	</photoUrls>\n" +
                                "	<tags>\n" +
                                "		<Tag>\n" +
                                "			<id>0</id>\n" +
                                "			<name>string</name>\n" +
                                "		</Tag>\n" +
                                "	</tags>\n" +
                                "	<status>available</status>\n" +
                                "</Pet>";

            // Set the request body
            StringEntity entity = new StringEntity(requestBody, "UTF-8");
            entity.setContentType("application/xml");
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);

           
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Response Code: " + statusCode);

       
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
