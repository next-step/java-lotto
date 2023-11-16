package lotto.service;

import java.util.*;
import lotto.domain.LottoNumber;

public class ValidationCheck {
    private static final int MIN_AMOUNT = 1000;
    public static void validatePurchaseAmount(int amount) {
        if(amount < MIN_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinningNumbersLength(String input) {
        int length = input.split(",").length;
        if(length!=6) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNoDuplicateWinningNumbers(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            throw new IllegalArgumentException();
        }
    }
}
