package lotto.domain.lotto;

import lotto.domain.exception.InvalidMoneyException;

public class LottoYieldCalculator {
    private LottoYieldCalculator() {
    }

    public static double calculateYield(int revenue, int money) {
        if (money == 0) {
            throw new InvalidMoneyException();
        }
        return revenue / (double) money;
    }
}
