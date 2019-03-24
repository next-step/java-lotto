package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static List<Integer> strToIntegerList(String str){
        return strToIntegerList(str, ",");
    }

    public static List<Integer> strToIntegerList(String str, String separator){
        return Arrays.stream(str.split(separator))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }
}
