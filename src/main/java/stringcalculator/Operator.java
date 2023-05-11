package stringcalculator;

public enum Operator {

    PLUS("+") {
        public int apply(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract int apply(int x, int y);

    public static Operator getOperator(String operator) {
        switch (operator) {
            case "+":
                return PLUS;
            case "-":
                return MINUS;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new IllegalArgumentException("사용할 수 없는 기호입니다.");
        }
    }
}
