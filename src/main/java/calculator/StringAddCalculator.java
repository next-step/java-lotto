package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (!isValidText(text)) {
            return 0;
        }

        return add(parseOperands(text));
    }

    static boolean isValidText(String text) {
        return !(text == null || text.isEmpty());
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
            sum += checkValidOperand(operands[i]);
        }

        return sum;
    }

    static int checkValidOperand(String operand) {
        int num = Integer.parseInt(operand);

        if (num < 0) {
            throw new IllegalArgumentException("음수는 유효하지 않습니다.");
        }

        return num;
    }
}
