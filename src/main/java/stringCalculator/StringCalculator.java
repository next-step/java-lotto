package stringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        return Arrays.asList(matcher.find() ?
                matcher.group("source").split(matcher.group("divider")) :
                source.split(",|:"));
    }

    private static int sum(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> convertToIntegers(List<String> values) {
        return values.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
