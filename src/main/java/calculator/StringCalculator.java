package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String DELIMITER = " ";
    private static final String CHECK_NUMBER_REGEXP = "^[0-9]+$";

    private static final String VALIDATE_EXPRESSION_REGEXP = "^[0-9\\s\\+\\-\\*\\/]+$";

    public static int calculate(String expression) {
        validateExpression(expression);

        List<Integer> operands = parseOperands(expression);
        List<Operation> operations = convertToOperations(expression);

        return operate(operands, operations);
    }

    private static void validateExpression(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("계산식이 입력되지 않았습니다.");
        }

        if (!expression.matches(VALIDATE_EXPRESSION_REGEXP)) {
            throw new IllegalArgumentException("계산식에 유효하지 않은 문자가 포함되었습니다.");
        }
    }

    private static List<Integer> parseOperands(String expression) {
        return Arrays.stream(expression.split(DELIMITER))
                .filter(value -> value.matches(CHECK_NUMBER_REGEXP))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Operation> convertToOperations(String expression) {
        return Arrays.stream(expression.split(DELIMITER))
                .filter(value -> !value.matches(CHECK_NUMBER_REGEXP))
                .map(Operation::getOperation)
                .collect(Collectors.toList());
    }

    private static int operate(List<Integer> operands, List<Operation> operations) {
        List<Integer> copiedOperands = new ArrayList<>(operands);

        for (Operation operation : operations) {
            copiedOperands.set(1, operation.apply(copiedOperands.get(0), copiedOperands.get(1)));
            copiedOperands.remove(0);
        }

        return copiedOperands.get(0);
    }
}
