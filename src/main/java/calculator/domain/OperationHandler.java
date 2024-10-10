package calculator.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OperationHandler {
    public static final String INPUT_IS_NOT_NUMBER = "입력된 값이 숫자가 아닙니다.";
    public static final String INPUT_IS_NOT_OPERATOR_SYMBOL = "사칙연산 기호가 아닙니다.";
    public static final String NOTHING_TO_CACULATE = "계산 할 수 없습니다.";
    private final Queue<String> operations;

    public OperationHandler(String[] operationArrays) {
        this.operations = new LinkedList<>(Arrays.asList(operationArrays));
    }

    public int calculate() {
        int calc = convertStringToInt(operations.poll());
        while (!operations.isEmpty()) {
            validateCalcSize(operations);
            Operation operation = new Operation(calc, operations.poll(), convertStringToInt(operations.poll()));
            calc = operation.execute();
        }
        return calc;
    }

    private void validateCalcSize(Queue<String> queue) {
        if (queue.size() < 2) {
            throw new IllegalArgumentException(NOTHING_TO_CACULATE);
        }
    }

    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }
}
