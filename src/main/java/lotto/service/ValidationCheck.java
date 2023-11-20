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

    public static void validateNoDuplicateBonusNumbers(Set<Integer> list, int number) {
        if(list.contains(number)){
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }
}