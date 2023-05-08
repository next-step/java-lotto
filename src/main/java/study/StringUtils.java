package study;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> split(String value) {
        return Arrays.asList(value.split(" "));
    }

    public static Integer parseInt(String value) {
        return Integer.valueOf(value);
    }
}
