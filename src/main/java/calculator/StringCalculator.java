package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = " ";
    private static final Pattern NUMERIC_REGEX_PATTERN = Pattern.compile("^[+-]?\\d*(\\.?\\d*)$");
    private static final Pattern OPERATION_SYMBOL_REGEX_PATTERN = Pattern.compile("[+\\-*/]");

    public static String[] split(String textInput) {
        isBlank(textInput);
        String[] values = isSizeEvenNumber(textInput.split(DEFAULT_DELIMITER));

        for (int i = 0; i < values.length; i++) {
            isValidArrayElement(i, values[i]);
        }

        return values;
    }

    public static String calculate(String textInput) {
        String[] values = split(textInput);

        String result = values[0];

        for (int i = 1; i < values.length - 1; i += 2) {
            String symbol = values[i];
            result = Operation.findBySymbol(symbol).operate(result, values[i + 1]);
        }

        return result;
    }

    private static void isBlank(String textInput) {
        if (textInput == null || textInput.isBlank()) {
            throw new IllegalArgumentException("입력된 문자열이 null 또는 공백 일 수 없습니다.");
        }
    }

    private static String[] isSizeEvenNumber(String[] values) {
        if (isEvenNumber(values.length)) {
            throw new IllegalArgumentException("분리된 문자열 배열 size 는 짝수 일 수 없습니다.");
        }
        return values;
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == ZERO;
    }

    private static void isValidArrayElement(int index, String value) {
        if (isEvenNumber(index + 1)) {
            isOperationSymbol(value);
            return;
        }

        isNumber(value);
    }

    private static void isNumber(String value) {
        if (!NUMERIC_REGEX_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    private static void isOperationSymbol(String value) {
        if (!OPERATION_SYMBOL_REGEX_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("사칙연산 기호 이외의 값은 입력할 수 없습니다.");
        }
    }

    public enum Operation {
        PLUS("+") {
            @Override
            String operate(String x, String y) {
                return new BigDecimal(x).add(new BigDecimal(y)).toString();
            }
        },
        MINUS("-") {
            @Override
            String operate(String x, String y) {
                return new BigDecimal(x).subtract(new BigDecimal(y)).toString();
            }
        },
        MULTIPLY("*") {
            @Override
            String operate(String x, String y) {
                return new BigDecimal(x).multiply(new BigDecimal(y)).toString();
            }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        abstract String operate(String x, String y);

        public static Operation findBySymbol(String symbol) {
            return Arrays.stream(Operation.values())
                    .filter(s -> s.symbol.equals(symbol))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("입력한 사칙연산에 해당하는 code 가 없습니다."));
        }
    }

}

