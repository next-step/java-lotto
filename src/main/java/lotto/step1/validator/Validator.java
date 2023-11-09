package lotto.step1.validator;

import java.util.List;

public class Validator {
    public static void validateUserInputString(final String input) {
        validateNullAndEmpty(input);
        validateNumberAndOperator(input);
    }

    private static void validateNumberAndOperator(final String input) {
        for (int i = 0; i < input.length(); i++) {
            throwErrorIfNotNumberAndNotOperatorAndNotWhiteSpace(input.charAt(i));
        }
    }

    private static void throwErrorIfNotNumberAndNotOperatorAndNotWhiteSpace(final char ch) {
        if (!Character.isDigit(ch) && !isOperator(ch) && !Character.isSpaceChar(ch)) {
            throw new IllegalArgumentException("숫자와 사칙연산 기호만 입력이 가능합니다.");
        }
    }

    private static boolean isOperator(final char ch) {
        final List<Character> operators = List.of('+', '-', '*', '/');
        return operators.contains(ch);
    }

    private static void validateNullAndEmpty(final String input) {
        validateNull(input);
        validateEmpty(input);
    }

    private static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력은 빈 공백이 될 수 없습니다.");
        }
    }

    private static void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력은 null이 될 수 없습니다.");
        }
    }
}
