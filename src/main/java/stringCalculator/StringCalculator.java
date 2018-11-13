package stringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String source) {
        if (source == null || source.isEmpty()) {
            return 0;
        }

        return sum(convertToIntegers(split(source)));
    }

    private static List<String> split(String source) {
        Pattern pattern = Pattern.compile("//(?<divider>.)\n(?<source>.*)");
        Matcher matcher = pattern.matcher(source);

        if (matcher.find()) {
            return Arrays.asList(matcher.group("source").split(matcher.group("divider")));
        }

        return Arrays.asList(source.split(",|:"));
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
