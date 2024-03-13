package step1;

import java.util.Arrays;
import java.util.List;

public enum Operation {
    PLUS("+") {
        int apply(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        int apply(int x, int y) {
            if (y == 0) {
                return 0;
            }

            return x / y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    abstract int apply(int x, int y);

    private static final String INVALID_OPERATOR = "유효하지 않은 연산자 입니다 : %s";
    private static final List<Operation> operations = Arrays.asList(values());

    public static Operation find(String operator) {
        return operations.stream()
                .filter(operation -> operation.sameSymbol(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(INVALID_OPERATOR, operator)));
    }

    public static int performOperation(int operand1, String operator, int operand2) {
        Operation operation = find(operator);
        return operation.apply(operand1, operand2);
    }

    private boolean sameSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
