package calculator;

import java.util.List;
import java.util.Set;

public class InputValidator {

    public static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public static void validate(String input) {
        validateBlank(input);
        validateExpression(input);
    }

    public static void validate(List<String> inputItems) {
        for (String item : inputItems) {
            validateSpaceBetweenItems(item);
        }
    }

    private static void validateSpaceBetweenItems(String item) {
        if (isNotOperatorOrNumber(item)) {
            throw new IllegalArgumentException("숫자, 사칙연산자(+, -, *, /) 사이에는 공백이 있어야 합니다");
        }
    }

    private static boolean isNotOperatorOrNumber(String item) {
        return !OPERATORS.contains(item) && !isNumber(item);
    }

    private static boolean isNumber(String item) {
        return item.matches("-?\\d+");
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열이나 공백으로 구성된 문자열은 허용되지 않습니다");
        }
    }

    private static void validateExpression(String input) {
        for (int index = 0; index < input.length(); index++) {
            Character character = input.charAt(index);
            if (isInValidExpression(character)) {
                throw new IllegalArgumentException("숫자, 사칙연산자(+, -, *, /), 공백 이외의 문자는 허용되지 않습니다");
            }
        }
    }

    private static boolean isInValidExpression(Character character) {
        return !isValidExpression(character);
    }

    private static boolean isValidExpression(Character character) {
        return Character.isDigit(character) || OPERATORS.contains(character.toString()) || Character.isWhitespace(character);
    }
}
