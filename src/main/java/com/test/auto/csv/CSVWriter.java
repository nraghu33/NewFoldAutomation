package com.test.auto.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CSVWriter {
    private String fileName;
    private BufferedWriter bw;

    public CSVWriter(String fileName) throws IOException {
        File file = new File(fileName);
//        if(file.exists()) {
//            file.delete();
//        }
        bw = new BufferedWriter(new FileWriter(file));
        bw.write("CustomerID,Journey,JourneyStage,Error_Response");
        bw.newLine();
        bw.flush();
    }

    public void write(String str) throws IOException {
        bw.write(str);
        bw.newLine();
    }

    public void close() throws IOException {
        bw.close();
    }
}