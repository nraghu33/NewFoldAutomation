package com.test.auto;

import com.test.auto.models.CustomerJourney;
import com.test.auto.models.RankedResult;
import com.test.auto.threadtask.SingleThreadClient;
import com.test.auto.utils.Constant;
import com.test.auto.csv.CSVReader;
import com.test.auto.csv.CSVWriter;
import com.test.auto.threadtask.MultiThreadClient;
import com.test.auto.utils.Utils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Testing {

    public static String channel, conatinerName, reportFileName;
    public static Map<String, CustomerJourney> map = null;

    public  static Properties pr = null;

    public static void main(String[] args) throws IOException {
        System.out.println("\n$$$$$$$$$$$$$$$$$$" + args.length + "\n");

        if (args.length == 2) {
            channel = args[0];
            conatinerName = args[1];
        }
        pr = new Properties();
        pr.load(new FileReader("application.properties"));

//        MultiThreadClient threadClient = new MultiThreadClient(
//                pr.getProperty(Constant.THREAD_COUNT.name()),
//                pr.getProperty(Constant.POST_API_URL.name()),
//                pr.getProperty(Constant.AUTH_TOKEN.name())
//        );
//
//        readInputCSVAndSendPostRequest(pr, threadClient);
//
//        writeOutputCSVFile(pr, threadClient);

//        readInputCSVAndSendPostRequest(pr, threadClient);
//        writeOutputCSVFile(pr, threadClient);

        SingleThreadClient threadClient = new SingleThreadClient(
                pr.getProperty(Constant.THREAD_COUNT.name()),
                pr.getProperty(Constant.POST_API_URL.name()),
                pr.getProperty(Constant.AUTH_TOKEN.name())
        );

        map = readInputCSVAndSendPostRequest(pr, threadClient);


        //writeOutputCSVFile(pr, map);
    }

    private static void readInputCSVAndSendPostRequest(Properties pr, MultiThreadClient threadClient) throws IOException {
        CSVReader csvReader = new CSVReader(pr.getProperty(Constant.INPUT_CSV_FILE_PATH.name()));
        String str = null;
        BufferedReader br = csvReader.getCSVReader();

        JSONObject jsonObject = Utils.parseJSONFile(pr.getProperty(Constant.REQUEST_JSON_FILE_PATH.name()));

        boolean skipFirstRecord = true;
        while ((str = br.readLine()) != null) {
            if (skipFirstRecord) {
                skipFirstRecord = false;
            } else {
                String customerId = str.split(",")[0];
                jsonObject.put("CustomerID", customerId);
                if (conatinerName != null && channel != null) {
                    jsonObject.put("Channel", channel);
                    jsonObject.put("ContainerName", conatinerName);
                }
                System.out.println("XXXXXXXXXXXXXXX" + customerId + "------" + jsonObject.toString() + "XXXXXXXXXXXXXXX\n");
                threadClient.sendRequest(jsonObject.toString());
            }
        }
        csvReader.close();
    }

    public static String getReportFileName(){
        return reportFileName;
    }

    public static Map<String, CustomerJourney> readInputCSVAndSendPostRequest(Properties pr, SingleThreadClient threadClient) throws IOException {
        CSVReader csvReader = new CSVReader(pr.getProperty(Constant.INPUT_CSV_FILE_PATH.name()));
        Map<String, CustomerJourney> map = new LinkedHashMap<>();
        String str = null;
        BufferedReader br = csvReader.getCSVReader();

        JSONObject jsonObject = Utils.parseJSONFile(pr.getProperty(Constant.REQUEST_JSON_FILE_PATH.name()));

        boolean skipFirstRecord = true;
        while ((str = br.readLine()) != null) {
            if (skipFirstRecord) {
                skipFirstRecord = false;
            } else {
                String customerId = str.split(",")[0];
                jsonObject.put("CustomerID", customerId);
                if (conatinerName != null && channel != null) {
                    jsonObject.put("Channel", channel);
                    jsonObject.put("ContainerName", conatinerName);
                }
                System.out.println("XXXXXXXXXXXXXXX" + customerId + "------" + jsonObject.toString() + "XXXXXXXXXXXXXXX\n");
                map.put(customerId, threadClient.sendRequest(jsonObject.toString()));
            }
        }
        csvReader.close();
        return map;
    }

    public static void writeOutputCSVFile(Properties pr, Map<String, CustomerJourney> result) throws IOException {
        reportFileName = pr.getProperty(Constant.OUTPUT_CSV_FILE_PATH.name()) + "_" + channel + "_" + conatinerName + "_" + LocalDateTime.now()+".csv";
        CSVWriter csvWriter = new CSVWriter(reportFileName);
        for (Map.Entry<String, CustomerJourney> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : Response-- " + entry.getValue());
            if (entry.getValue()!=null && entry.getValue().getContainerList()!=null && entry.getValue().getContainerList().size() > 0 &&
                    entry.getValue().getContainerList().get(0).getNextBestActions()!=null && entry.getValue().getContainerList().get(0).getNextBestActions().size() > 0) {
                List<RankedResult> rankedResults = entry.getValue().getContainerList().get(0).getNextBestActions().get(0).getRankedResults();
                StringBuilder sb = null;
                for (RankedResult rankedResult : rankedResults) {
                    sb = new StringBuilder(entry.getKey() + ",");
                    boolean flag = false;
                    if (rankedResult != null && rankedResult.getJourney() != null && "" != rankedResult.getJourney()
                            && rankedResult.getJourneyStage() != null && "" != rankedResult.getJourneyStage()) {
                        sb.append(rankedResult.getJourney() + "," + rankedResult.getJourneyStage() + ",");
                        flag = true;
                    } else {
                        sb.append(",,,");
                    }

                    if (flag) {
                        break;
                    }
                }
                csvWriter.write(sb.toString());
            }
        }
        csvWriter.close();
    }

    private static void writeOutputCSVFile(Properties pr, MultiThreadClient threadClient) throws IOException {
        CSVWriter csvWriter = new CSVWriter(pr.getProperty(Constant.OUTPUT_CSV_FILE_PATH.name()));
        List<CustomerJourney> result = threadClient.getResult();
        for (CustomerJourney abc : result) {
            System.out.println("Response: " + abc);
            List<RankedResult> rankedResults = abc.getContainerList().get(0).getNextBestActions().get(0).getRankedResults();

            for (RankedResult rankedResult : rankedResults) {
                StringBuilder sb = new StringBuilder();
                boolean a = false, b = false;
                if (rankedResult != null && rankedResult.getJourney() != null) {

                }
                if (rankedResult != null && rankedResult.getJourneyStage() != null) {

                }
            }
            csvWriter.write(abc.toString());
        }
        csvWriter.close();
    }

    public static Map<String, CustomerJourney> getMap(){
        return map;
    }

    public static Properties getPr(){
        return pr;
    }
}
