package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    private static final String DELIMITER_FOR_LAST_LOTTO_NUM = ",";

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
        String[] split = input.split(DELIMITER_FOR_LAST_LOTTO_NUM);
        return Arrays.stream(split)
                .map(stringNumber -> validateNonNumberForNumbers(stringNumber))
                .collect(Collectors.toList());
    }

    private static Integer validateNonNumberForNumbers(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}