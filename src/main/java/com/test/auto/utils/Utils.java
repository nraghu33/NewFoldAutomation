package com.test.auto.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.json.JSONException;

public class Utils {
    public static JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        String conFileName = new File(filename).getCanonicalPath();
        String content = new String(Files.readAllBytes(Paths.get(conFileName)));
        return new org.json.JSONObject(content);
    }
}
