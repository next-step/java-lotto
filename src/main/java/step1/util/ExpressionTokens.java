package step1.util;

import step1.domain.Operator;

import java.util.List;

public class ExpressionTokens {
    public static List<String> parseTokens(String input) {
        List<String> tokens = List.of(input.split(" "));
        validate(tokens);
        return tokens;
    }

    private static void validate(List<String> tokens) {
        if (tokens == null || tokens.size() == 0) {
            throw new IllegalArgumentException("수식은 빈 값일 수 없습니다.");
        }

        if (tokens.size() % 2 == 0) {
            throw new IllegalArgumentException("수식의 길이는 홀수여야 합니다.");
        }

        for (int i = 0; i < tokens.size(); i++) {
            validateTokenOrder(tokens, i);
        }
    }

    private static void validateTokenOrder(List<String> tokens, int i) {
        boolean isEvenIndex = (i % 2 == 0);

        if (isEvenIndex && !isNumber(tokens.get(i))) {
            throw new IllegalArgumentException("숫자가 있어야 할 자리에 연산자가 있습니다: " + tokens.get(i));
        }

        if (!isEvenIndex && !isOperator(tokens.get(i))) {
            throw new IllegalArgumentException("연산자가 있어야 할 자리에 숫자가 있습니다: " + tokens.get(i));
        }
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        try {
            Operator.from(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


}
