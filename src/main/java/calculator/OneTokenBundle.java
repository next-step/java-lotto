package calculator;

public class OneTokenBundle {
    private final String operator;
    private final String rightNumber;

    public OneTokenBundle(
            String operator,
            String rightNumber
    ) {
        this.operator = operator;
        this.rightNumber = rightNumber;
    }

    public String operator() {
        return operator;
    }

    public int rightNumber() {
        return Integer.parseInt(rightNumber);
    }
}
