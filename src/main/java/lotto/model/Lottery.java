package lotto.model;

import lotto.model.constants.Dividend;

import java.util.*;

public class Lottery {
    private final WinnerNumbers winnerNumbers;
    private final PurchasedLottos purchasedLottos;

    public Lottery(WinnerNumbers winnerNumbers, PurchasedLottos purchasedLottos) {
        this.winnerNumbers = winnerNumbers;
        this.purchasedLottos = purchasedLottos;
    }

    public long depositTotalMoney() {
        return purchasedLottos.depositTotalMoney(winnerNumbers);
    }

    public Map<Dividend, Integer> totalCorrect() {
        return purchasedLottos.totalCorrect(winnerNumbers);
    }

    public double getInvestment() {
        return (double) depositTotalMoney() / purchasedLottos.totalPurchasePrice();
    }
}
