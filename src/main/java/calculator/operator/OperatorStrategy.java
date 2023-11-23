package calculator.operator;

public enum OperatorStrategy {

    PLUS("+") {
        @Override
        public boolean matchable(String operator) {
            return this.expression.equals(operator);
        }

        @Override
        public long calculate(long sum, long operand) {
            return sum + operand;
        }
    },
    MINUS("-") {
        @Override
        public boolean matchable(String operator) {
            return this.expression.equals(operator);
        }

        @Override
        public long calculate(long sum, long operand) {
            return sum - operand;
        }
    },
    MULTIPLY("*") {
        @Override
        public boolean matchable(String operator) {
            return this.expression.equals(operator);
        }

        @Override
        public long calculate(long sum, long operand) {
            return sum * operand;
        }
    },
    DIVIDE("/") {
        @Override
        public boolean matchable(String operator) {
            return this.expression.equals(operator);
        }

        @Override
        public long calculate(long sum, long operand) {
            return sum / operand;
        }
    };

    protected final String expression;

    OperatorStrategy(String expression) {
        this.expression = expression;
    }

    public abstract boolean matchable(String operator);

    public abstract long calculate(long sum, long operand);
}
