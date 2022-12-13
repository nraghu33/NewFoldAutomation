package com.test.auto.threadtask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import com.test.auto.models.CustomerJourney;
import org.springframework.web.client.RestTemplate;

public class MultiThreadClient {
    private static final RestTemplate restTemplate = createRestTemplate();
    private ExecutorService executor;
    private String url, authToken;
    private List<Future<CustomerJourney>> list;

    public MultiThreadClient(String count, String url, String authToken){
        executor = Executors.newFixedThreadPool(Integer.parseInt(count));
        this.url= url;
        this.authToken = authToken;
        list = new ArrayList<>();
    }

    public void sendRequest(String body) {
        list.add(executor.submit(new APIRequest(restTemplate, url, body, authToken)));
//        String response = null;
//        try {
//            //response = future.get();
//            response = future.get(500, TimeUnit.MILLISECONDS);
//        }
//        catch (TimeoutException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        return response;
    }

    public List<CustomerJourney> getResult() {
        List<CustomerJourney> result =new ArrayList<>();
        for (Future<CustomerJourney> future : list) {
            try {
                //System.out.println(future.get());
                result.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static RestTemplate createRestTemplate(){
     return new RestTemplate();
    }

}
