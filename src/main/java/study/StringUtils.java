package study;

import java.util.List;

public class StringUtils {

    public static List<String> split(String value) {
        return List.of(value.split(" "));
    }
}
