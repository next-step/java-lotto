package step1.calculator.model;

import java.util.Map;

public enum Operation {

    ADD {
        @Override
        public int calculate(int x, int y) {
            return x + y;
        }
    }, SUBTRACT {
        @Override
        public int calculate(int x, int y) {
            return x - y;
        }
    }, MULTIPLY {
        @Override
        public int calculate(int x, int y) {
            return x * y;
        }
    }, DIVIDE {
        @Override
        public int calculate(int x, int y) {
            return x / y;
        }
    };

    public static final Map<String, Operation> OPERATIONS = Map.of(
        "+", ADD,
        "-", SUBTRACT,
        "*", MULTIPLY,
        "/", DIVIDE);

    public abstract int calculate(int x, int y);

}
