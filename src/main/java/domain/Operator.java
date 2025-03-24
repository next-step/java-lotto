package domain;

public class Operator {
    private final String value;

    public Operator(String value) {
        if (!validateOperator(value)) {
            throw new IllegalArgumentException("Invalid operator");
        }
        this.value = value;
    }

    public static Operator of(String value) {
        return new Operator(value);
    }

    public Integer operate(Operand firstOperand, Operand secondOperand) {
        if (this.value.equals("+")) {
            return firstOperand.value() + secondOperand.value();
        }

        if (this.value.equals("-")) {
            return firstOperand.value() - secondOperand.value();
        }

        if (this.value.equals("*")) {
            return firstOperand.value() * secondOperand.value();
        }

        if (this.value.equals("/")) {
            return firstOperand.value() / secondOperand.value();
        }

        throw new IllegalArgumentException("Invalid operator");
    }

    private boolean validateOperator(String value) {
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }
}
