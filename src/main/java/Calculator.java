import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import java.util.function.BinaryOperator;

public class Calculator {

    private static final String DEFAULT_FORMAT_REGEX = "^\\d+(?:\\s+[+\\-*/]\\s+\\d+)*$";
    private static final String WHITE_SPACE = " ";

    private Calculator() {
    }

    public static int calculate(String input) {
        assertionNotBlank(input);
        assertionValidFormat(input);

        List<Integer> numbers = getNumbers(input);
        List<Character> operations = getOperations(input);
        int prev = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            prev = Operator.operate(operations.get(i - 1), prev, numbers.get(i));
        }
        return prev;
    }

    private static void assertionNotBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력 값은 null이거나 공백일 수 없습니다.");
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static void assertionValidFormat(String input) {
        if (isNotValidFormat(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    private static boolean isNotValidFormat(String input) {
        return !input.matches(DEFAULT_FORMAT_REGEX);
    }

    private static List<Integer> getNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = input.split(WHITE_SPACE);
        for (int i = 0; i < split.length; i += 2) {
            numbers.add(Integer.parseInt(split[i]));
        }
        return numbers;
    }

    private static List<Character> getOperations(String input) {
        List<Character> operations = new ArrayList<>();
        String[] split = input.split(WHITE_SPACE);
        for (int i = 1; i < split.length; i += 2) {
            operations.add(split[i].charAt(0));
        }
        return operations;
    }

    public enum Operator {
        PLUS('+', Integer::sum),
        MINUS('-', (a, b) -> a - b),
        MULTIPLE('*', (a, b) -> a * b),
        DIVIDE('/', (a, b) -> a / b);

        private static final Map<Character, Operator> SYMBOL_TO_OPERATOR;

        static {
            SYMBOL_TO_OPERATOR = new HashMap<>();
            for (Operator operator : values()) {
                SYMBOL_TO_OPERATOR.put(operator.getSymbol(), operator);
            }
        }

        private final char symbol;
        private final BiFunction<Integer, Integer, Integer> expression;

        Operator(char symbol, BiFunction<Integer, Integer, Integer> expression) {
            this.symbol = symbol;
            this.expression = expression;
        }

        public char getSymbol() {
            return this.symbol;
        }

        public static int operate(char symbol, int a, int b) {
            return SYMBOL_TO_OPERATOR.get(symbol).expression.apply(a, b);
        }
    }
}
