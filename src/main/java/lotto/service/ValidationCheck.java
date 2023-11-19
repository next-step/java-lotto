package lotto.service;

import java.util.*;

public class ValidationCheck {
    private static final int MIN_AMOUNT = 1000;
    public static void validatePurchaseAmount(int amount) {
        if(amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("구입금액은 1천원 이상이어야 합니다.");
        }
    }

    public static void validateWinningNumbersLength(String input) {
        int length = input.split(",").length;
        if(length!=6) {
            throw new IllegalArgumentException("당첨번호는 6자리여야 합니다.");
        }
    }

    public static void validateNoDuplicateWinningNumbers(Set<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            throw new IllegalArgumentException("당첨번호는 중복될 수 없습니다.");
        }
    }
}
