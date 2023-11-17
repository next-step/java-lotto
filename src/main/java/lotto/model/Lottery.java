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

    public long depositTotalMoney(){
        long totalMoney = 0;
        for (int i = MIN_CORRECT_COUNT; i <= MAX_CORRECT_COUNT; i++) {
            totalMoney += Dividend.findWinnerMoney(Dividend.getDividend(i), checkForWin(i));
        }
        return totalMoney;
    }
    public double getInvestment() {
        return (double) depositTotalMoney() / lottos.totalPurchasePrice();
    }

    public int checkForWin(int correctCount) {
        return lottos.correctCount(winnerNumbers, correctCount);
    }

}
