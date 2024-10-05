package textcalculator;

public enum Operator {
    PLUS("+") {
        @Override
        int apply(int x, int y) {
            return x + y;
        }
    }
    , MINUS("-") {
        @Override
        int apply(int x, int y) {
            return x - y;
        }
    }, TIMES("*") {
        @Override
        int apply(int x, int y) {
            return x * y;
        }
    }, DIVIDE("/") {
        @Override
        int apply(int x, int y) {
            return x / y;
        }
    };

    Operator(final String symbol){
        this.symbol = symbol;
    }

    private final String symbol;

    abstract int apply(int x, int y);
}
