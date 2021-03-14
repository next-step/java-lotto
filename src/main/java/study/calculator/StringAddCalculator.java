package study.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if(Objects.isNull(text) || text.isEmpty()) { // null 또는 ""
            return 0;
        }

        if(text.length() == 1 && isNumeric(text)) {
            return Integer.parseInt(text);
        }

        List<Integer> numbers = split(text);
        return numbers.stream()
                .reduce(Integer::sum)
                .get();
    }

    private static List<Integer> split(String text) {
        String[] split = text.split(",|:");
        return Arrays.stream(split)
                .filter(StringAddCalculator::isNumeric)
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
