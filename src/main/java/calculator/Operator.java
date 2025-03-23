package calculator;

public class Operator {

    private String value;

    public Operator(String value) {
        this.value = value;
    }
    public Operand calculate(Operand left, Operand right) {
        if (value.equals("+")) {
            return left.add(right);
        }

        return left.add(right);
    }
}
