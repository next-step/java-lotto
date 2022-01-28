package stringcalculator.domain;

import java.util.List;

public class Validator {

    public static void validatePositiveNumber(final List<String> tokens) {
        tokens.forEach(token -> {
            final int intToken = validateTypeOfToken(token);
            if(intToken < 0) {
                throw new IllegalArgumentException("[Error]: 양수만 연산 가능합니다.");
            }
        });
    }

    public static int validateTypeOfToken(final String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[Error]: 숫자만 연산 가능합니다.");
        }
    }
}
