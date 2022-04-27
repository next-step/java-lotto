package stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static final String OPERATORS = "[-*/+]";

    public static int splitAndCalculate(String input) {
        int answer = 0;
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }

        String[] calculations = input.split(" ");
        for (int i = 0; i < calculations.length; i++) {
            validateOperation(calculations[i]);
        }
        return answer;
    }

    private static void validateOperation(String calculation) {
        if(!Pattern.matches(OPERATORS, calculation)) {
            throw new IllegalArgumentException("연산자는 +, -, *, / 기호만 입력 가능합니다.");
        }
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }
}
