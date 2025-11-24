package calculator.model;

import java.util.Arrays;

public class Operator {
    private Symbol symbol;

    public Operator(String input) {
        this.symbol = Symbol.of(input);
    }

    public Number calculate(Number former, Number latter) {
        return symbol.calculate(former, latter);
    }

    private enum Symbol {
        PLUS("+") {
            @Override
            public Number calculate(Number operand1, Number operand2) {
                return new Number(operand1.value() + operand2.value());
            }
        },
        MINUS("-") {
            @Override
            public Number calculate(Number operand1, Number operand2) {
                return new Number(operand1.value() - operand2.value());
            }
        },
        MULTIPLY("*") {
            @Override
            public Number calculate(Number operand1, Number operand2) {
                return new Number(operand1.value() * operand2.value());
            }
        },
        DIVIDE("/") {
            @Override
            public Number calculate(Number operand1, Number operand2) {
                if (!operand1.isDividableBy(operand2)) {
                    throw new IllegalArgumentException("나눗셈의 결과가 정수가 아닙니다.");
                }
                return new Number(operand1.value() / operand2.value());
            }
        };

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

        public abstract Number calculate(Number operand1, Number operand2);
    };
}
