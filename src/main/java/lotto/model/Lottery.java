package lotto.model;

import lotto.model.constants.Dividend;

import java.util.*;

public class Lottery {
    private final WinnerNumbers winnerNumbers;
    private final TotalLottos totalLottos;

    public Lottery(WinnerNumbers winnerNumbers, TotalLottos totalLottos) {
        this.winnerNumbers = winnerNumbers;
        this.totalLottos = totalLottos;
    }

    public long depositTotalMoney() {
        long totalMoney = 0;
        for (Lotto lotto : totalLottos.lottoList()) {
            totalMoney += winnerNumbers.winnerMoney(lotto);
        }
        return totalMoney;
    }

    public Map<Dividend, Integer> totalCorrect() {
        Map<Dividend, Integer> correctCountResult = new HashMap<>();
        for (Lotto lotto : totalLottos.lottoList()) {
            Dividend dividend = winnerNumbers.winResult(lotto);
            correctCountResult.put(dividend, correctCountResult.getOrDefault(dividend, 0) + 1);
        }
        return correctCountResult;
    }

    public double getInvestment() {
        return (double) depositTotalMoney() / totalLottos.totalPurchasePrice();
    }
}
