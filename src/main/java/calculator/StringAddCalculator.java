package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return add(parseOperands(text));
    }

    static String[] parseOperands(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(",|:");
    }

    static int add(String[] operands) {
        int sum = 0;

        for (int i = 0; i < operands.length; i++) {
            sum += Integer.parseInt(operands[i]);
        }

        return sum;
    }
}
