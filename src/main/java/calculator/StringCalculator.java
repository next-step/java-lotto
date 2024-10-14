package calculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {

    private static final String DELIMITER = " ";
    private static final int FIRST_INDEX = 0;

    private static final Map<String, Operation> operations = new HashMap();

    static {
        operations.put(Operator.PLUS.symbol, new Plus());
        operations.put(Operator.MINUS.symbol, new Minus());
        operations.put(Operator.MULTIPLY.symbol, new Multiply());
        operations.put(Operator.DIVISION.symbol, new Division());
    }

    public int calculator(String input) {
        validationInput(input);

        String[] inputSplit = input.split(DELIMITER);
        int result = Integer.parseInt(inputSplit[FIRST_INDEX]);

        for (int i = 1; i < inputSplit.length; i++) {
            result = isOdd(i) ? solve(inputSplit[i], result, Integer.parseInt(inputSplit[i + 1]))
                    : result;
        }
        return result;
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

    private static int solve(String operator, int result, int number) {
        Operation operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("사칙연산 기호가 아닐 경우에는 계산되지 않습니다.");
        }
        return operation.apply(result, number);
    }

    private static void validationInput(String input) {
        if (input == null || input.trim().isBlank()) {
            throw new IllegalArgumentException("입력값이 null이거나 공백문자인 경우 계산되지 않습니다.");
        }
    }
}
