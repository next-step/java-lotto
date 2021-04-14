package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderUtil {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        String value = "";
        try {
            value = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
