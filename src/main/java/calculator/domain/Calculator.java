package calculator.domain;

import java.util.Arrays;
import java.util.OptionalInt;

public class Calculator {

    private static final String DELIMITER_POSITION = " ";
    private static final String PLUS = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final int START_NUMBER = 0;

    public static int calculator(String rawString) {
        validate(rawString);
        String[] seperateString = split(rawString);
        int calculatingValue = setInitialValue(seperateString);
        return calculate(seperateString, calculatingValue);
    }

    private static void validate(String rawString) {
        if (rawString == null || rawString.isBlank()) {
            throw new IllegalArgumentException("계산식을 입력해주세요");
        }
    }
    private static int calculate(String[] seperateString, int calculatingValue) {
        for (int i = 1; i < seperateString.length-1; i+=2) {
            if (PLUS.equals(seperateString[i])) {
                calculatingValue += Integer.parseInt(seperateString[i+1]);
                continue;
            }
            if (MULTIPLY.equals(seperateString[i])) {
                calculatingValue *= Integer.parseInt(seperateString[i+1]);
                continue;
            }
            if (SUBTRACT.equals(seperateString[i])) {
                calculatingValue -= Integer.parseInt(seperateString[i+1]);
                continue;
            }
            if (DIVIDE.equals(seperateString[i])) {
                calculatingValue /= Integer.parseInt(seperateString[i+1]);
                continue;
            }
            throw new IllegalArgumentException("사칙연산 기호만 입력해주세요");
        }
        return calculatingValue;
    }

    private static int setInitialValue(String[] seperateString) {
        return Integer.parseInt(seperateString[START_NUMBER]);
    }

    private static String[] split(String rawString) {
        return rawString.split(DELIMITER_POSITION);
    }
}
