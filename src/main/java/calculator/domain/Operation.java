package calculator.domain;

public class Operation {
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

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
