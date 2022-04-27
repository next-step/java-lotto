package string_calculator;

public enum Operator implements Value {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODULO("%");

    private String value;
    Operator(String value) {
        this.value = value;
    }

    public static Operator create(String value) {
        if (PLUS.value.equals(value)) {
            return PLUS;
        }
        if (MINUS.value.equals(value)) {
            return MINUS;
        }
        if (MULTIPLY.value.equals(value)) {
            return MULTIPLY;
        }
        if (DIVIDE.value.equals(value)) {
            return DIVIDE;
        }
        if (MODULO.value.equals(value)) {
            return MODULO;
        }
        throw new IllegalArgumentException("only [+, -, *, /, %] are allowed. but: " + value);
    }

    public Integer compute(Integer acc, Integer operand) {
        switch (this) {
            case PLUS:
                return new Integer(acc.value() + operand.value());
            case MINUS:
                return new Integer(acc.value() - operand.value());
            case MULTIPLY:
                return new Integer(acc.value() * operand.value());
            case DIVIDE:
                divideByZeroChecker(operand);
                return divideToInteger(acc, operand);
            case MODULO:
                return new Integer(acc.value() % operand.value());
        }
        throw new IllegalArgumentException("Wrong operator was used.");
    }

    private Integer divideToInteger(Integer acc, Integer operand) {
        Boolean isDividable =  acc.value() % operand.value() == 0;
        if (isDividable) {
            return new Integer(acc.value() / operand.value());
        }
        throw new IllegalArgumentException("Can't divide.");
    }

    private void divideByZeroChecker(Integer operand) {
        if (operand.value() == 0) {
            throw new ArithmeticException("Can't divide by Zero.");
        }
    }

}
