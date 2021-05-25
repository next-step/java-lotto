package lotto.domain;

import lotto.common.WinningType;

import java.util.List;

public class ProfitCalculator {
    public double calculate(long money, List<WinningType> winningTypes) {
        long prizeSum = 0;
        for (WinningType winningType : winningTypes) {
            prizeSum += winningType.getPrize();
        }

        return calculate(money, prizeSum);
    }

    public double calculate(long money, long prizeSum) {
        return Math.floor(((double) prizeSum/money)*100)/100.0;
    }
}
