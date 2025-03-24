package domain;

public class Operator {
    private final OperatorType value;

    public Operator(String value) {
        this.value = OperatorType.findOperatorByString(value);
    }

    public static Operator of(String value) {
        return new Operator(value);
    }

    public Integer operate(Operand firstOperand, Operand secondOperand) {
        if (this.value.equals(OperatorType.ADD)) {
            return firstOperand.value() + secondOperand.value();
        }

        if (this.value.equals(OperatorType.SUBTRACT)) {
            return firstOperand.value() - secondOperand.value();
        }

        if (this.value.equals(OperatorType.MULTIPLY)) {
            return firstOperand.value() * secondOperand.value();
        }

        if (this.value.equals(OperatorType.DIVIDE)) {
            return firstOperand.value() / secondOperand.value();
        }

        throw new IllegalArgumentException("Invalid operator");
    }
}
