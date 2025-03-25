package StringCalculator.domain;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 + operand2;
        }
    }, MINUS("-") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLY("*") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 * operand2;
        }
    }, DIVIDE("/") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 / operand2;
        }
    };

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public abstract int calculate(int operand1, int operand2);

    public static Operator from(String input) {
        for (Operator operator : Operator.values()) {
            if (operator.getSign().equals(input)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("not admit operator : " + input);
    }
}

