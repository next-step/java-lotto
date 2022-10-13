package Lotto;

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Operator{}";
    }

    public abstract int operate(int num1, int num2);

    public static Operator operatorOf(String value) {
        if (value.equals("+")) return add;
        if (value.equals("-")) return subtract;
        if (value.equals("*")) return multiple;
        if (value.equals("/")) return divide;
        return null;
    }
}