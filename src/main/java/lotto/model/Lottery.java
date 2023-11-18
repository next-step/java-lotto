package lotto.model;

import lotto.model.constants.Dividend;

public class Lottery {
    public static final int MIN_CORRECT_COUNT = 3;
    public static final int MAX_CORRECT_COUNT = 6;
    private final WinnerNumbers winnerNumbers;
    private final Lottos lottos;

    public Lottery(WinnerNumbers winnerNumbers, Lottos lottos) {
        this.winnerNumbers = winnerNumbers;
        this.lottos = lottos;
    }

    public long depositTotalMoney() {
        long totalMoney = 0;
        for (int correctCount = MIN_CORRECT_COUNT; correctCount <= MAX_CORRECT_COUNT; correctCount++) {
            totalMoney += Dividend.valueOf(correctCount, false)
                    .findWinnerMoney(checkForWin(correctCount, false));
            totalMoney = depositSecondMoney(totalMoney, correctCount);
        }
        return totalMoney;
    }

    private long depositSecondMoney(long totalMoney, int correctCount) {
        if (correctCount == Dividend.SECOND.correctCount()) {
            totalMoney += Dividend.valueOf(correctCount, true)
                    .findWinnerMoney(checkForWin(correctCount, true));
        }
        return totalMoney;
    }

    public double getInvestment() {
        return (double) depositTotalMoney() / lottos.totalPurchasePrice();
    }

    public int checkForWin(int correctCount, boolean needBonus) {
        return (int) lottos.matchCountAndBonus(winnerNumbers)
                .stream()
                .filter(numbers -> numbers.isMatchNumberAndBonus(correctCount, needBonus))
                .count();
    }

}
