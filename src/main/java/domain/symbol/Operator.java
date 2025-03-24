package domain.symbol;

public class Operator {
    private final OperatorType value;

    public Operator(String value) {
        this.value = OperatorType.findOperatorByString(value);
    }

    public static Operator of(String value) {
        return new Operator(value);
    }

    public Operand operate(Operand firstOperand, Operand secondOperand) {
        switch (this.value) {
            case ADD:
                return new Operand(add(firstOperand, secondOperand));
            case SUBTRACT:
                return new Operand(subtract(firstOperand, secondOperand));
            case MULTIPLY:
                return new Operand(multiply(firstOperand, secondOperand));
            case DIVIDE:
                return new Operand(divide(firstOperand, secondOperand));
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private Integer add(Operand firstOperand, Operand secondOperand) {
        return firstOperand.value() + secondOperand.value();
    }

    private Integer subtract(Operand firstOperand, Operand secondOperand) {
        return firstOperand.value() - secondOperand.value();
    }

    private Integer multiply(Operand firstOperand, Operand secondOperand) {
        return firstOperand.value() * secondOperand.value();
    }

    private Integer divide(Operand firstOperand, Operand secondOperand) {
        return firstOperand.value() / secondOperand.value();
    }
}
