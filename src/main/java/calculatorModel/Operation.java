package calculatorModel;

public class Operation {

    public enum Operator {
        ADD("+") {
            public int apply(int x, int y) {
                return x + y;
            }
        },
        SUBTRACT("-") {
            public int apply(int x, int y) {
                return x - y;
            }
        },
        MULTIPLY("*") {
            public int apply(int x, int y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            public int apply(int x, int y) {
                if (!checkDivideValue(x, y)) {
                    throw new IllegalArgumentException("나눗셈 결과 값이 정수로 떨어지지 않습니다.");
                }
                return x / y;
            }

            public boolean checkDivideValue(int x, int y) {
                if (x % y != 0) {
                    return false;
                }
                return true;
            }
        };

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public abstract int apply(int x, int y);

        public static Operator fromString(String symbol) {
            for (Operator op : Operator.values()) {
                if (op.symbol.equals(symbol)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Invalid operator: " + symbol);
        }
    }

}
