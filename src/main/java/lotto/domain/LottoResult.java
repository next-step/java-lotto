package lotto.domain;

import java.util.List;

public class LottoResult {

    private final List<Prize> prizes;
    private final int purchaseAmount;

    public LottoResult(Lottos myLottos, Lotto winningLotto) {
        this.prizes = myLottos.calculatePrizes(winningLotto);
        this.purchaseAmount = myLottos.purchaseAmount();
    }

    public int countOf(Prize prize) {
        return (int) prizes.stream()
                .filter(p -> p == prize)
                .count();
    }

    public long totalPrize() {
        return prizes.stream()
                .mapToLong(Prize::getMoney)
                .sum();
    }

    public double profitRate() {
        double profitRate = (double) totalPrize() / purchaseAmount;
        return Math.floor(profitRate * 100) / 100;
    }
}
