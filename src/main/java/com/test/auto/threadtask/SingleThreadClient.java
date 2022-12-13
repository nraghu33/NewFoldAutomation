package com.test.auto.threadtask;

import com.test.auto.models.CustomerJourney;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SingleThreadClient {
    private static final RestTemplate restTemplate = createRestTemplate();
    private String url, authToken;

    public SingleThreadClient(String count, String url, String authToken){
        this.url= url;
        this.authToken = authToken;
    }

    public CustomerJourney sendRequest(String body) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("auth-token", authToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(body, header);
        ResponseEntity<CustomerJourney> response= restTemplate.postForEntity(url, httpEntity , CustomerJourney.class);

        return response.getBody();
    }

    private static RestTemplate createRestTemplate(){
     return new RestTemplate();
    }

}
