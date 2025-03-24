import java.util.Arrays;
import java.util.List;

public enum ArithmeticOperator {
    ADDITION("+") {
        @Override
        public int operate(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int operate(int firstNumber, int secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int operate(int firstNumber, int secondNumber) {
            return firstNumber * secondNumber;
        }
    },
    DIVISION("/") {
        @Override
        public int operate(int firstNumber, int secondNumber) {
            if (secondNumber == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return firstNumber / secondNumber;
        }
    };

    private static final List<String> VALID_OPERATORS = Arrays.asList(
        ADDITION.symbol,
        SUBTRACTION.symbol,
        MULTIPLICATION.symbol,
        DIVISION.symbol
    );
    private final String symbol;

    ArithmeticOperator(String symbol) {
        this.symbol = symbol;
    }

    public static boolean isValidOperator(String operator) {
        return VALID_OPERATORS.contains(operator);
    }

    public static ArithmeticOperator fromSymbol(String symbol) {
        for (ArithmeticOperator arithmeticOperator : values()) {
            if (arithmeticOperator.getSymbol().equals(symbol)) {
                return arithmeticOperator;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol);
    }

    public abstract int operate(int firstNumber, int secondNumber);

    public String getSymbol() {
        return symbol;
    }
} 