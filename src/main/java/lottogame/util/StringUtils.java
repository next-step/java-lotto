package lottogame.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || s.length() <= 0;
    }

    public static boolean isEmpty(List<String> strs) {
        return strs == null || strs.size() <= 0;
    }

    public static boolean isEmpty(String[] strs) {
        return strs == null || strs.length <= 0;
    }

    public static String repeat(String s, int count) {
        if(isEmpty(s))
            return "";

        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < count; ++i ) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static Set<Integer> parseIntegerSet(String[] strings) {
        return Arrays.stream(strings)
                .filter(string -> !StringUtils.isEmpty(string))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static String removeWhitespace(String string) {
        return Optional.ofNullable(string)
                        .orElse("")
                        .replaceAll("\\s+", "");
    }
}
