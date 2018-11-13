package stringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int add(String source) {
        if (source == null || source.isEmpty()) {
            return 0;
        }

        return sum(convertToIntegers(split(source)));
    }

    private static List<String> split(String source) {
        return Arrays.asList(source.split(","));
    }

    private static int sum(List<Integer> values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }

    private static List<Integer> convertToIntegers(List<String> values) {
        List<Integer> results = new ArrayList<>();
        for (String value : values) {
            results.add(Integer.parseInt(value));
        }
        return results;
    }
}
