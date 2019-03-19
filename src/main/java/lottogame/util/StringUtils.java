package lottogame.util;

import java.util.*;
import java.util.stream.Collectors;

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

    public static int parseInt(String s) {
        return Optional.ofNullable(s)
                        .map(String::trim)
                        .map(StringUtils::getInteger)
                        .orElse(0);
    }

    public static long parseLong(String s) {
        return Optional.ofNullable(s)
                .map(String::trim)
                .map(StringUtils::getLong)
                .orElse(0L);
    }


    public static Integer getInteger(String str) {
        try {
            return Integer.valueOf(str);
        } catch(Exception e) {
            return 0;
        }
    }

    public static Long getLong(String str) {
        try {
            return Long.valueOf(str);
        } catch(Exception e) {
            return 0L;
        }
    }

    public static List<Integer> parseIntegerList(String[] strings) {
        return Optional.ofNullable(strings)
                        .filter(array -> array.length > 0)
                        .map(Arrays::asList)
                        .orElse(Collections.emptyList())
                        .stream()
                        .filter(s -> !StringUtils.isEmpty(s))
                        .map(StringUtils::getInteger)
                        .collect(Collectors.toList());
    }

    public static String removeWhitespace(String string) {
        return Optional.ofNullable(string)
                        .orElse("")
                        .replaceAll("\\s+", "");
    }
}
