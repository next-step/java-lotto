package lotto.domain;

import java.util.List;

public class Calculator {
    private static final String INPUT_DELIMITER = " ";
    private static final String NOT_NATURAL_NUMBER_MESSAGE = "자연수가 아닙니다.";
    private static final String EMPTY_INPUT_MESSAGE = "입력걊이 비어있습니다.";

    public static int calculate(String input) {
        checkInputIsNullOrEmpty(input);
        List<String> symbols = List.of(input.split(INPUT_DELIMITER));
        Operand result = Operand.valueOf(symbols.get(0));
        for (int i = 1; i < symbols.size(); i = i + 2) {
            String operatorSymbol = symbols.get(i);
            Operator operator = Operator.getInstance(operatorSymbol);
            String operandSymbol = symbols.get(i + 1);
            Operand operand = Operand.valueOf(operandSymbol);
            result = Operand.valueOf(operator.calculate(result, operand));
        }
        return result.value();
    }

    private static void checkInputIsNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }

    private static int convertToIntOperand(String operandSymbol) {
        try {
            return Integer.parseInt(operandSymbol);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_MESSAGE);
        }
    }
}
