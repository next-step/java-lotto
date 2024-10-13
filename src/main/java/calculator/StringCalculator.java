package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static final String DELIMITER = " ";

    public static int calculate(String input) {
        InputValidator.validate(input);
        List<String> inputItems = Arrays.asList(input.split(DELIMITER));
        int result = 0;

        InputValidator.validate(inputItems);

        Integer operandA = null;
        Integer operandB = null;
        OperationType operation = null;

        for (String item : inputItems) {
            if (InputItemType.isOperator(item)) {
                operation = OperationType.fromSymbol(item);
                continue;
            }

            int parsedOperand = Integer.parseInt(item);
            if (operandA == null) {
                operandA = parsedOperand;
                continue;
            }

            if (operation == null) {
                throw new IllegalArgumentException("유효하지 않은 연산자가 입력되었습니다");
            }

            operandB = parsedOperand;
            result = operation.apply(operandA, operandB);
            operandA = result;
        }

        return result;
    }
}
