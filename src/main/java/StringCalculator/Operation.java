package StringCalculator;

import java.util.Arrays;

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
            return x / y;
        }
    };

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    abstract int apply(int x, int y);

    public static Operation getInstanceByValue(String value) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getValue().equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
