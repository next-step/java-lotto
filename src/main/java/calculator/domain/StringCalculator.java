package calculator.domain;

import java.util.List;

public class StringCalculator {

    private static final String ADDICTION = "+";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String SUBTRACTION = "-";

    private StringCalculator() {}

    public static int calculate(List<String> tokens) {
        int result = getInitialNumber(tokens);
        String operator = "";
        for (String token: removeInitialNumber(tokens)) {
            try {
                int number = convertToInt(token);
                result = operate(result, operator, number);
            } catch (NumberFormatException e) {
                operator = token;
            }
        }
        return result;
    }

    private static int convertToInt(String token) {
        return Integer.parseInt(token);
    }

    private static int getInitialNumber(List<String> tokens) {
        return convertToInt(tokens.get(0));
    }

    private static List<String> removeInitialNumber(List<String> tokens) {
        return tokens.subList(1, tokens.size());
    }

    private static int operate(int result, String operator, int number) {
        switch (operator) {
            case ADDICTION:
                result += number;
                break;
            case MULTIPLICATION:
                result *= number;
                break;
            case SUBTRACTION:
                result -= number;
                break;
            case DIVISION:
                result /= number;
                break;
            default:
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return result;
    }

}
