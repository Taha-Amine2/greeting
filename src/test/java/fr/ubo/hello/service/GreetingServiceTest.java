package fr.ubo.hello.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ubo.hello.bean.Greeting;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreetingServiceTest {

    @Test
    public void badGreeting() throws ClientProtocolException, IOException {
        HttpClient client = new DefaultHttpClient();

        String url = "http://localhost:8080/ArchiJEEWSRestTP-1.0-SNAPSHOT/api/greeting/badGreeting";

        HttpGet mockRequest = new HttpGet(url);

        mockRequest.setHeader("http-user", "test-user");

        HttpResponse mockResponse = client.execute(mockRequest);

        BufferedReader rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity().getContent()));
        ObjectMapper mapper = new ObjectMapper();
        Greeting g = mapper.readValue(rd, Greeting.class);

        Assert.assertNotNull("Greeting doit pas etre null", g);

        Assert.assertFalse("Greeting message should not contain 'name'", g.getMessage().contains("name"));

        String expectedMessage = "Name est obligatoire. Merci de le renseigner.";
        Assert.assertNotEquals(expectedMessage, g.getMessage());
    }
}