package stringCalculator;

import java.util.Arrays;

public enum Operator {
    ADDITION("+") {
        long  process(long x, long y) {
            return x + y;
        }
    },
    SUBTRACTION("-") {
        long process(long x, long y) {
            return x - y;
        }
    },
    MULTIPLICATION("*") {
        long process(long x, long y) {
            return x * y;
        }
    },
    DIVISION("/") {
        long process(long x, long y) {
            if (y == 0) {
                throw new ArithmeticException("Division by zero is not allowed");
            }
            return x / y;
        }
    };

    private final String mark;
    private static final String INVALID_INPUT_ERROR = "Only Numbers and + - * are allowed (Wrong input) : ";

    Operator(String mark) {
        this.mark = mark;
    }

    abstract long process(long x, long y);

    public static long processWithValidation(long x, String mark, long y) {
        try {
            Operator operator = findMark(mark);
            return operator.process(x, y);
        } catch(IllegalArgumentException exception) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_ERROR, mark));
        }
    }

    private static Operator findMark(String operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.mark.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid operator: " + operator));
    }
}
