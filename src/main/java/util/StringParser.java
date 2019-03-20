package util;

import java.util.Arrays;

public class StringParser {
    public static Integer[] strToIntegerArray(String str){
        return strToIntegerArray(str, ",");
    }

    public static Integer[] strToIntegerArray(String str, String separator){
        return Arrays.stream(str.split(separator))
            .map(String::trim)
            .map(Integer::valueOf)
            .toArray(Integer[]::new);
    }
}
