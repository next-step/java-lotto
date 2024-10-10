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
        OperationType operation = OperationType.UNKNOWN;

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

            operandB = parsedOperand;
            result = operation.apply(operandA, operandB);
            operandA = result;
        }

        return result;
    }
}
