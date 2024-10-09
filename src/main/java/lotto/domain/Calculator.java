package lotto.domain;

import java.util.List;

public class Calculator {
    private static final String INPUT_DELIMITER = " ";
    private static final String EMPTY_INPUT_MESSAGE = "입력걊이 비어있습니다.";

    public static int calculate(String input) {
        checkInputIsBlank(input);
        List<String> symbols = List.of(input.split(INPUT_DELIMITER));
        int result = Integer.parseInt(symbols.get(0));
        for (int i = 1; i < symbols.size(); i = i + 2) {
            String operatorSymbol = symbols.get(i);
            Operator operator = Operator.getInstance(operatorSymbol);
            String operandSymbol = symbols.get(i + 1);
            int operand = Integer.parseInt(operandSymbol);
            result = operator.calculate(result, operand);
        }
        return result;
    }

    private static void checkInputIsBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }
}
