package lotto.domain;

import java.util.List;

import static lotto.domain.Winnings.*;

public class LottoReport {
    private int threeMatched;
    private int fourMatched;
    private int fiveMatched;
    private int sixMatched;
    private double purchasedAmount;
    private double yield;
    private long winnings;

    public LottoReport(Lotto winners, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            updateMatchedNumberMetrics(winners, lotto);
        }
        updateYield(lottos.size());
    }

    private void updateMatchedNumberMetrics(Lotto winners, Lotto test) {
        int matched = test.matchCountWith(winners);
        FIFTH.ifMatchedThan(matched, () -> threeMatched++);
        FOURTH.ifMatchedThan(matched, () -> fourMatched++);
        THIRD.ifMatchedThan(matched, () -> fiveMatched++);
        FIRST.ifMatchedThan(matched, () -> sixMatched++);
    }

    private void updateYield(int lottoSize) {
        purchasedAmount = lottoSize * Lotto.PRICE;
        updateWinnings();
        yield = Math.floor((winnings / purchasedAmount) * 100) / 100.0;
    }

    private void updateWinnings() {
        this.winnings = threeMatched * FIFTH.winnings +
                fourMatched * FOURTH.winnings +
                fiveMatched * THIRD.winnings +
                sixMatched * FIRST.winnings;
    }

    public int threeMatched() {
        return threeMatched;
    }

    public int fourMatched() {
        return fourMatched;
    }

    public int fiveMatched() {
        return fiveMatched;
    }

    public int sixMatched() {
        return sixMatched;
    }

    public double yield() {
        return yield;
    }

}
