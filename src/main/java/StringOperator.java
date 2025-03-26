import java.util.Arrays;

import static java.lang.Integer.parseInt;

public enum StringOperator {
    ADD("+") {
        @Override
        public String calculate(String num1, String num2) {
            int result = parseInt(num1) + parseInt(num2);
            return String.valueOf(result);
        }
    },
    SUBTRACT("-") {
        @Override
        public String calculate(String num1, String num2) {
            int result = parseInt(num1) - parseInt(num2);
            return String.valueOf(result);
        }
    },
    MULTIPLY("*") {
        @Override
        public String calculate(String num1, String num2) {
            int result = parseInt(num1) * parseInt(num2);
            return String.valueOf(result);
        }


    },
    DIVIDE("/") {
        @Override
        public String calculate(String num1, String num2) {
            int parsedNum1 = parseInt(num1);
            int parsedNum2 = parseInt(num2);

            validate(parsedNum1, parsedNum2);
            int result = parsedNum1 / parsedNum2;
            return String.valueOf(result);
        }

        void validate(int num1, int num2) {
            if (num1 % num2 != 0) {
                throw new IllegalArgumentException("나머지가 존재합니다. 연산이 불가능합니다. ");
            }
        }
    };

    private final String symbol;

    StringOperator(String symbol) {
        this.symbol = symbol;
    }

    public static StringOperator from(String symbol) {
        return Arrays.stream(values())
            .filter(op -> op.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol));
    }

    public abstract String calculate(String num1, String num2);
}
