package calculator.model;

import java.util.Arrays;

public class Operator {
    private Symbol symbol;

    public Operator(String input) {
        this.symbol = Symbol.of(input);
    }

    public Number calculate(Number former, Number latter) {
        return switch (symbol) {
            case PLUS -> symbol.plus(former, latter);
            case MINUS -> symbol.minus(former, latter);
            case MULTIPLY -> symbol.multiply(former, latter);
            case DIVIDE -> symbol.divide(former, latter);
        };
    }

    private enum Symbol {
        PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

        private String symbol;

        Symbol(String symbol) {
            this.symbol = symbol;
        }

        static Symbol of(String input) {
            return Arrays.stream(values())
                    .filter(symbol -> symbol.symbol.equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산자입니다."));
        }

        Number plus(Number left, Number right) {
            return left.plus(right);
        }

        Number minus(Number left, Number right) {
            return left.minus(right);
        }

        Number multiply(Number left, Number right) {
            return left.multiply(right);
        }

        Number divide(Number left, Number right) {
            return left.divide(right);
        }
    }
}
