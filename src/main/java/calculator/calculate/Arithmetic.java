package calculator.calculate;

public enum Arithmetic {
    ADD("+") {
        public int apply(int a, int b) {
            return a + b;
        }
    },
    MINUS("-") {
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        public int apply(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };

    Arithmetic(String symbol) {
        this.symbol = symbol;
    }

    private String symbol;


    public String getSymbol() {
        return symbol;
    }

    public abstract int apply(int a, int b);

    public static Arithmetic fromSymbol(String symbol) {
        for (Arithmetic arithmetic : Arithmetic.values()) {
            if (isSame(symbol, arithmetic)) {
                return arithmetic;
            }
        }
        throw new IllegalArgumentException("유효하지 않는 기호입니다.");
    }

    private static boolean isSame(String symbol, Arithmetic arithmetic) {
        return arithmetic.getSymbol().equals(symbol);
    }

    public int getCalculate(int a, int b) {
        return 1;
    }

}
