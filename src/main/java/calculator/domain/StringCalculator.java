package calculator.domain;

import calculator.domain.operator.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCalculator {

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
        Map<String, Operator> operations = new HashMap<>();
        operations.put(new Addition().symbol(), new Addition());
        operations.put(new Multiplication().symbol(), new Multiplication());
        operations.put(new Subtraction().symbol(), new Subtraction());
        operations.put(new Division().symbol(), new Division());

        Operator operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return operation.operate(result, number);
    }

}
