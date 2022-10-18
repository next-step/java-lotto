package calculator.operator;

public enum OperatorType {

    ADD("+", new AddOperator()),
    MINUS("-", new MinusOperator()),
    MULTIPLY("*", new MultiplyOperator()),
    DIVIDE("/", new DivideOperator());

    private final String operatorStr;
    private final Operator operator;

    OperatorType(String operatorStr, Operator operator) {
        this.operatorStr = operatorStr;
        this.operator = operator;
    }

    public static OperatorType from(String input) {
        switch (input) {
            case "+":
                return ADD;
            case "-":
                return MINUS;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new IllegalArgumentException("wrong operator type");
        }
    }
}
