package com.masterUsecse.soapUI;



import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpGetExample {
    public static void main(String[] args) {
    	
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
        HttpGet httpGet = new HttpGet("https://petstore.swagger.io/");
       

        try {
            HttpResponse response = httpClient.execute(httpGet);

           
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Response Code: " + statusCode);
            System.out.println(httpGet);

         
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
