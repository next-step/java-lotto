package lotto.model;

import lotto.model.constants.Dividend;

import java.util.*;

public class Lottery {
    private final WinnerNumbers winnerNumbers;
    private final Lottos lottos;

    public Lottery(WinnerNumbers winnerNumbers, Lottos lottos) {
        this.winnerNumbers = winnerNumbers;
        this.lottos = lottos;
    }

    public long depositTotalMoney() {
        long totalMoney = 0;
        for (Lotto lotto : lottos.lottoList()) {
            totalMoney += winnerNumbers.winnerMoney(lotto);
        }
        return totalMoney;
    }

    public Map<Dividend, Integer> totalCorrect() {
        Map<Dividend, Integer> correctCountResult = new HashMap<>();
        for (Lotto lotto : lottos.lottoList()) {
            Dividend dividend = winnerNumbers.winResult(lotto);
            correctCountResult.put(dividend, correctCountResult.getOrDefault(dividend, 0) + 1);
        }
        return correctCountResult;
    }

    public double getInvestment() {
        return (double) depositTotalMoney() / lottos.totalPurchasePrice();
    }
}
