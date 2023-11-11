package calculator.service;

import java.util.regex.Pattern;

public class Calculator {

    private static int result = 0;
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public static int getResult(String[] input) {
        result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i += 2) {
            calculate(result, input[i].charAt(0), Integer.parseInt(input[i + 1]));
        }
        return result;
    }

    private static int calculate(int firstNum, char operator, int SecondNum) {
        if (operator == '+') {
            result = firstNum + SecondNum;
        }

        if (operator == '-') {
            result = firstNum - SecondNum;
        }

        if (operator == '*') {
            result = firstNum * SecondNum;
        }

        if (operator == '/') {
            result = firstNum / SecondNum;
        }
        return result;
    }
}
