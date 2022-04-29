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

        for (int i = 0; i < calculations.length-2; i+=2) {
            calculations[i+2] = String.valueOf(calculate(calculations[i+1], calculations[i], calculations[i+2]));
            answer = Integer.parseInt(calculations[i+2]);
        }
        return answer;
    }

    private static int calculate(String operator, String firstOperand, String secondOperand) {
        validateOperation(operator);
        if("+".equals(operator)) {
            return add(Integer.parseInt(firstOperand), Integer.parseInt(secondOperand));
        }

        if("-".equals(operator)) {
            return subtract(Integer.parseInt(firstOperand), Integer.parseInt(secondOperand));
        }

        if("*".equals(operator)) {
            return multiply(Integer.parseInt(firstOperand), Integer.parseInt(secondOperand));
        }

        return divide(Integer.parseInt(firstOperand), Integer.parseInt(secondOperand));
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
