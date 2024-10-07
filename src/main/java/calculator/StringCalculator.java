package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringCalculator {
    public static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");
    private static StringCalculator INSTANCE = null;

    private StringCalculator() {
    }

    public static StringCalculator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StringCalculator();
        }
        return INSTANCE;
    }

    public String[] split(String text) {
        if (isBlank(text)) {
            throw new IllegalStateException("문자열이 비어있습니다.");
        }
        return text.split(" ");
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    public boolean isOperator(String operator) {
        if (!isContainOperator(operator)) {
            throw new IllegalStateException("연산자가 아닌 문자는 허용하지 않습니다.");
        }
        return true;
    }

    private boolean isContainOperator(String operator) {
        return OPERATORS.contains(operator);
    }

    public int parseNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("숫자가 아닌 문자는 허용하지 않습니다.");
        }
    }

    public boolean isValidStackSize(Stack<Integer> numbers, Stack<String> operators) {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalStateException("연산이 성립되지 않습니다.");
        }
        return true;
    }
}
