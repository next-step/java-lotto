package string_calculator;

public enum Operator {
    ADD {
        @Override
        public int operate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public int operate(int a, int b) {
            return a / b;
        }
    };

    private static final String ILLEGAL_ARGUMENT_ERROR_MESSAGE = "사칙연산 기호가 아닙니다.";
    private static final char ADD_CHAR = '+';
    private static final char SUBTRACT_CHAR = '-';
    private static final char MULTIPLY_CHAR = '*';
    private static final char DIVIDE_CHAR = '/';

    public abstract int operate(int a, int b);

    public static Operator from(char opChar) {
        if (opChar == ADD_CHAR) {
            return ADD;
        }

        if (opChar == SUBTRACT_CHAR) {
            return SUBTRACT;
        }

        if (opChar == MULTIPLY_CHAR) {
            return MULTIPLY;
        }

        if (opChar == DIVIDE_CHAR) {
            return DIVIDE;
        }

        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
    }

    public static Operator from(String opString) {
        if (opString.length() > 1) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
        }

        return from(opString.charAt(0));
    }
}