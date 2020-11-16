package step01;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static String tokens = ",|:";

    public static int splitAndSum(String input) {
        if (input == null || input.trim() == "") {
            return 0;
        }

        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {

        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        String[] numbers;

        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
        } else {
            numbers = input.split(tokens);
        }
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> {
                    if (a < 0) {
                        throw new RuntimeException("음수는 계산할 수 없습니다.");
                    }
                    return a + b;
                });

    }
}
