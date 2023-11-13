package calculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+"){
        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    }
    , MINUS("-"){
        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    }
    , MULTIPLE("*"){
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    }
    , DIVIDE("/"){
        @Override
        public int calculate(int num1, int num2) {
            return num1 / num2;
        }
    };

    private final String symbol;

    Operator(String symbol){
        this.symbol = symbol;
    }

    public abstract int calculate(int num1, int num2);

    public static Operator getOperatorBySymbol(String symbol){
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }
}
