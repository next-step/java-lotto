package calculator.operator;

public enum Operation implements Operator {

    PLUS("+") {
        @Override
        public boolean match(String expression) {
            return "+".equals(expression);
        }

        @Override
        public long calculate(long sum, long operand) {
            return sum + operand;
        }
    },
    MINUS("-") {
        @Override
        public boolean match(String expression) {
            return "-".equals(expression);
        }

        @Override
        public long calculate(long sum, long operand) {
            return sum - operand;
        }
    },
    MULTIPLY("*") {
        @Override
        public boolean match(String expression) {
            return "*".equals(expression);
        }

        @Override
        public long calculate(long sum, long operand) {
            return sum * operand;
        }
    },
    DIVIDE("/") {
        @Override
        public boolean match(String expression) {
            return "/".equals(expression);
        }

        @Override
        public long calculate(long sum, long operand) {
            return sum / operand;
        }
    };

    private final String expression;

    Operation(String expression) {
        this.expression = expression;
    }
}
