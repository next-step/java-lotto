package calculator;

import java.util.List;

public class InputValidator {
    public static void validate(String input) {
        validateBlank(input);
        validateExpression(input);
    }

    public static void validate(List<String> inputItems) {
        validateFirstItemIsNumber(inputItems);
        for (String item : inputItems) {
            validateSpaceBetweenItems(item);
        }
        validateSequentialItem(inputItems);
    }

    private static void validateSpaceBetweenItems(String item) {
        if (isNotOperatorOrNumber(item)) {
            throw new IllegalArgumentException("숫자, 사칙연산자(+, -, *, /) 사이에는 공백이 있어야 합니다");
        }
    }

    private static void validateFirstItemIsNumber(List<String> items) {
        InputItemType firstItemType = InputItemType.from(items.get(0));
        if (!items.isEmpty() && firstItemType != InputItemType.NUMBER) {
            throw new IllegalArgumentException("가장 첫 항목은 숫자이어야 합니다");
        }
    }

    private static void validateSequentialItem(List<String> items) {
        InputItemType prevItemType = null;

        for (String item : items) {
            InputItemType currentItemType = InputItemType.from(item);

            if (prevItemType == currentItemType) {
                throw new IllegalArgumentException("숫자나 사칙연산자(+, -, *, /)는 연속되어 입력될 수 없습니다");
            }

            prevItemType = currentItemType;
        }
    }

    private static boolean isNotOperatorOrNumber(String item) {
        InputItemType itemType = InputItemType.from(item);
        return !itemType.isOperator() && !itemType.isNumber();
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
        String characterString = character.toString();
        return InputItemType.from(characterString) == InputItemType.UNKNOWN;
    }
}
