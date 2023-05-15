package step1.domain;

import java.util.Arrays;

public enum Operator {

    PLUS("+"){
        @Override
        long calculate(long first, long second) {
            return first + second;
        }
    },
    MINUS("-") {
        @Override
        long calculate(long first, long second) {
            return first - second;
        }
    },
    MULTIPLE("*") {
        @Override
        long calculate(long first, long second) {
            return first * second;
        }
    },
    DIVIDE("/") {
        @Override
        long calculate(long first, long second) {
            return first / second;
        }
    };
    private final String symbol;
    abstract long calculate(long first, long second);

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator symbolOf(String symbol){
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void checkOperator(String operatorSymbol) {
        Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(operatorSymbol))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
