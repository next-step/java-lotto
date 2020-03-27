package lotto;

import java.util.List;

public class StringConverter {
    public static Money convertStringToMoney(String input) {
        return new Money(validateNonNumber(input));
    }

    private static Long validateNonNumber(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public static List<Integer> convertStringToNumbers(String input) {
        return null;
    }
}