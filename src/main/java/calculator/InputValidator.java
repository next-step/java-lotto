package calculator;

import java.util.List;

public class InputValidator {
    public static void validate(String input) {
        validateBlank(input);
    }

    public static void validate(List<String> inputItems) {
        validateFirstItemIsNumber(inputItems);
        validateSequentialItem(inputItems);
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
}
