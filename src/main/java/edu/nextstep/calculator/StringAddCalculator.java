package edu.nextstep.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static Number[] nums;

    public static int splitAndSum(String input) {
        if (isNull.isFilter(input)) {
            return 0;
        }

        String[] tokens = split(input);
        toNumber(tokens);

        return plus(nums);
    }

    private static void toNumber(String[] tokens) {
        nums = new Number[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = new Number(Integer.valueOf(tokens[i]));
        }
    }

    private static int plus(Number[] numbers) {
        int result = 0;
        for( Number num : numbers) {
            result = result + num.getValue();
        }

        return result;
    }

    private static String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        String[] tokens= input.split(",|:");
        return tokens;
    }
}
