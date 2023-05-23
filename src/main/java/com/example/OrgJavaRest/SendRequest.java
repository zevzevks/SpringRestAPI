package com.example.OrgJavaRest;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class SendRequest {
    private static final Logger logger = LogManager.getLogger(SendRequest.class);
    public SendRequest(){

    }
    public void sendRequest(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            logger.debug("Test Send Request Method");
            System.out.println("Test Send Request Method");
            HttpPost request = new HttpPost("http://localhost:8080/adults/queryAdultTrain");
            StringEntity params = new StringEntity("[\n" +
                    "    {\n" +
                    "        \"columnName\": \"AGE\",\n" +
                    "        \"columnValueInt\": \"37\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"columnName\": \"EDUCATION\",\n" +
                    "        \"columnValueStr\": \"Masters\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"columnName\": \"WORKCLASS\",\n" +
                    "        \"columnValueStr\": \"Private\"\n" +
                    "    }\n" +
                    "]");
            //request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);
            HttpResponse response = (HttpResponse) httpClient.execute(request);
            System.out.println(response.toString());
        } catch (Exception ex) {
        } finally {
            // @Deprecated httpClient.getConnectionManager().shutdown();
        }
    }

}
