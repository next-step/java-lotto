package calculator.operator;

public enum OperatorType {

    ADD,
    MINUS,
    MULTIPLY,
    DIVIDE;

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
