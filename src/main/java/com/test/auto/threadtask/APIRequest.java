package com.test.auto.threadtask;
import com.test.auto.models.CustomerJourney;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//import java.util.HashMap;
//import java.util.Map;
import java.util.concurrent.*;
public class APIRequest implements Callable<CustomerJourney> {

    private RestTemplate restTemplate;
    private String url;
    private String body;
    private String authToken;

    public APIRequest(RestTemplate restTemplate, String url, String body, String authToken) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.body= body;
        this.authToken = authToken;
    }

    public CustomerJourney call() throws Exception {
//        String response = restTemplate.getForObject(url, String.class);
//        String reqBodyData = new ObjectMapper().writeValueAsString(bodyParamMap);
//        HttpEntity<String> requestEnty = new HttpEntity<>(reqBodyData, header);

//        Map<String, String> bodyParamMap = new HashMap<String, String>();
//        bodyParamMap.put("key1", "value1");
//        String  body = "";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("auth-token", authToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(body, header);
        //ResponseEntity<String>  response= restTemplate.postForEntity(url, httpEntity , String.class);

        ResponseEntity<CustomerJourney>  response= restTemplate.postForEntity(url, httpEntity , CustomerJourney.class);

        return response.getBody();
    }
}