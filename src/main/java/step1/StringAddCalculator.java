package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SPLIT_COMMON_STRING = "[,:]";
    private static final String SPLIT_CUSTOM_STRING = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        int result = 0;

        if (input == null || input.isEmpty()) {
            return result;
        }

        if (input.contains("-")) {
            throw new IllegalArgumentException("계산기에 음수는 올 수 없습니다.");
        }

        if (input.contains(",") || input.contains(":")) {
            String[] split = input.split(SPLIT_COMMON_STRING);
            return sum(split);
        }

        Matcher m = Pattern.compile(SPLIT_CUSTOM_STRING).matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] split = m.group(2).split(customDelimiter);
            // 덧셈 구현
            return sum(split);
        }

        return Integer.parseInt(input);
    }

    private static int sum(String[] split) {
        int result = 0;
        for (String str : split) {
            result += Integer.parseInt(str);
        }
        return result;
    }
}
