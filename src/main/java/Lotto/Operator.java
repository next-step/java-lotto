package lotto;

public abstract class Operator {
    private static final Operator add;
    private static final Operator subtract;
    private static final Operator multiple;
    private static final Operator divide;

    static {
        add = new Add();
        subtract = new Subtract();
        multiple = new Multiple();
        divide = new Divide();
    }

    public abstract int operate(int num1, int num2);

    public static Operator operatorOf(String value) {
        if (value.equals(OperatorType.ADD.type())) return add;
        if (value.equals(OperatorType.SUBTRACT.type())) return subtract;
        if (value.equals(OperatorType.MULTIPLE.type())) return multiple;
        if (value.equals(OperatorType.DIVIDE.type())) return divide;

        throw new IllegalArgumentException("사칙연산이 아닙니다.");
    }
}
