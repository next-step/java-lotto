public final class OperatorFactory {
    public static Operator createOperator(String operator) {
        switch (operator) {
            case "+":
                return new PlusOperator();
            case "-":
                return new MinusOperator();
            case "*":
                return new MultiplicationOperator();
            case "/":
                return new DivisionOperator();
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private OperatorFactory() {}
}
