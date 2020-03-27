package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    private static final String DELIMITER_FOR_LAST_LOTTO_NUM = ",";
    private static final Long MONEY_TO_BUY_ONE_LOTTO = 1000L;

    public static Money convertStringToMoney(String input) {
        Long money = validateNonNumber(input);
        validateEnoughToBuyLotto(money);
        return new Money(money);
    }

    private static Long validateNonNumber(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateEnoughToBuyLotto(Long money) {
        if (isLessThanOneThousand(money)) {
            throw new IllegalArgumentException("1000원 미만의 금액은 입력할 수 없습니다.");
        }
    }

    private static boolean isLessThanOneThousand(Long money) {
        return money < MONEY_TO_BUY_ONE_LOTTO;
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