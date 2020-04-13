package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private static Lotto lotto;
    private static int bonusNumber;

    private WinningNumbers(List<Integer> asList) {
    }

    public static WinningNumbers getInstance(List<Integer> asList) {
        return new WinningNumbers(asList);
    }
}
