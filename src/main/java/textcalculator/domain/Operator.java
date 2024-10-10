package textcalculator.domain;

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
            if(y == 0){
                throw new ArithmeticException("0으로 나눌 수 없습니다");
            }
            return x / y;
        }
    };

    Operator(final String symbol){
        this.symbol = symbol;
    }

    private final String symbol;

    abstract int apply(int x, int y);

    public boolean isSameSymbol(String operatorSymbol) {
        return this.symbol.equals(operatorSymbol);
    }
}
