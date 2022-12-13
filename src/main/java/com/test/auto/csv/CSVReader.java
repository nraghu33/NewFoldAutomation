package com.test.auto.csv;

import java.io.*;

public class CSVReader {
    private String fileName;
    private BufferedReader br;

    public CSVReader (String fileName) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(fileName));
    }

    public BufferedReader getCSVReader() {
        return br;
    }

    public void close() throws IOException {
        br.close();
    }
}
