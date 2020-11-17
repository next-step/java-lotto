package util;

import java.util.List;

public class CommonUtils {
    public static String[] listToArray(List<Integer> strings){
        return strings.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }
}
