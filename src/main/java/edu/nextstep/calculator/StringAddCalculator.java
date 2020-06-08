package edu.nextstep.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (isNull.isFilter(input)) {
            return 0;
        }



    }

    private int plus(int[] numbers) {
        int result = 0;
        for( int num : numbers) {
            result = result + num;
        }

        return result;
    }

    private String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

    }

}
