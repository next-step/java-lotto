package stringcalculator;

import java.util.stream.Stream;

public enum Operator {

    SUM("+") {
        public int calculateNumbers(int number1, int number2) {
            return number1 + number2;
        }
    },
    SUBTRACTION("-") {
        public int calculateNumbers(int number1, int number2) {
            return number1 - number2;
        }
    },
    MULTIPLICATION("*") {
        public int calculateNumbers(int number1, int number2) {
            return number1 * number2;
        }
    },
    DIVISION("/") {
        public int calculateNumbers(int number1, int number2) {
            return number1 / number2;
        }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract int calculateNumbers(int number1, int number2);

    static Operator findOperator(String value) {
        return Stream.of(values())
                .filter(operator -> operator.operator.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(value + "는 적합한 연산자가 아닙니다."));
    }

}
