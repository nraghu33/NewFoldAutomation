package steps;

import com.test.auto.Testing;
import com.test.auto.csv.CSVReader;
import com.test.auto.utils.Constant;
import io.cucumber.java.en.Given;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerJourney {

//    @Given("user send the request")
//    public void user_send_the_request() throws IOException {
//        Testing.main(new String[]{""});
//    }

    @Given("user sent the post request setting the channel {string} and container name as {string}")
    public void user_sent_the_post_request_setting_the_channel_and_container_name_as(String channel, String containerName) throws IOException {
        Testing.main(new String[]{channel,containerName});
    }
    @Given("I should get the customer Journey and Journey stage report")
    public void i_should_get_the_customer_Journey_and_Journey_stage_report() throws IOException {
        Testing.writeOutputCSVFile(Testing.getPr(), Testing.getMap());
//        CSVReader csvReader = new CSVReader(Testing.getReportFileName());
//        BufferedReader br = csvReader.getCSVReader();
//        String str=null;
//        while ((str = br.readLine()) != null) {
//            System.out.println(str+"£££££££");
//        }
    }

}

