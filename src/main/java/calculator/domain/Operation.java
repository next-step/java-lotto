package calculator.domain;

public class Operation {
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public static OperationStrategy getOperationStrategy(String operation) {
        if (operation.equals(ADD)) {
            return new OperationStrategyAdd();
        }
        if (operation.equals(SUBTRACT)) {
            return new OperationStrategySubtract();
        }
        if (operation.equals(MULTIPLY)) {
            return new OperationStrategyMultiply();
        }
        if (operation.equals(DIVIDE)) {
            return new OperationStrategyDivide();
        }
        return null;
    }
}
