package util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringConverter {
    public static List<Integer> StringToIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        while (stringTokenizer.hasMoreTokens()) {
            numbers.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        return numbers;
    }
}
