package calculator;

import java.util.ArrayList;
import java.util.List;

public class OperationElements {
    private static final int MIN_OPERANDS_COUNT = 2;

    private final List<OperationType> operators;
    private final List<Integer> operands;

    public OperationElements() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public OperationElements(List<OperationType> operators, List<Integer> operands) {
        this.operators = operators;
        this.operands = operands;
    }

    public void putOperationElement(String item) {
        InputItemType itemType = InputItemType.from(item);

        if (itemType == InputItemType.NUMBER) {
            putNumber(item);
            return;
        }

        if (itemType == InputItemType.OPERATOR) {
            putOperator(item);
        }
    }

    public int operate() {
        validateOperatorCount();
        validateOperandCount();

        int result = operands.get(0);
        for (int order = 0; order < operators.size(); order++) {
            OperationType operationType = operators.get(order);
            int operand = operands.get(order + 1);
            result = operationType.apply(result, operand);
        }

        return result;
    }

    private void putNumber(String item) {
        int parsedItem = parseItemToInteger(item);
        operands.add(parsedItem);
    }

    private void putOperator(String item) {
        OperationType operationType = OperationType.fromSymbol(item);
        operators.add(operationType);
    }

    private void validateOperatorCount() {
        if (operators.isEmpty()) {
            throw new IllegalArgumentException("연산자는 최소 1개는 입력되어야 합니다");
        }
    }

    private void validateOperandCount() {
        if (operands.size() < MIN_OPERANDS_COUNT) {
            throw new IllegalArgumentException("피연산자는 최소 2개는 입력되어야 합니다");
        }
    }

    private int parseItemToInteger(String item) {
        try {
            return Integer.parseInt(item);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자로 숫자가 아닌 값이 입력되었습니다");
        }
    }
}
