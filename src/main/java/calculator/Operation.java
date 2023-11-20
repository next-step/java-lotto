package calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    ADD("+") {
        public int apply(int number1, int number2) {
            return number1 + number2;
        }
    },
    SUBTRACT("-") {
        public int apply(int number1, int number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        public int apply(int number1, int number2) {
            return number1 * number2;
        }
    },
    DIVIDE("/") {
        public int apply(int number1, int number2) {
            if (number2 == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return number1 / number2;
        }
    };

    private static final Map<String, Operation> OPERATION_MAP = new HashMap<>();
    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    static {
        for (Operation operation : values()) {
            OPERATION_MAP.put(operation.operation, operation);
        }
    }

    public static Operation getOperationByElement(String element) {
        if (OPERATION_MAP.get(element) == null) {
            throw new IllegalArgumentException("Check input operation");
        }
        return OPERATION_MAP.get(element);
    }

    public abstract int apply(int number1, int number2);
}
