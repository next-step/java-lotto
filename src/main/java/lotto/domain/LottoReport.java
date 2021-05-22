package lotto.domain;

import java.util.List;

import static lotto.domain.Rank.*;

public class LottoReport {
    private int threeMatched;
    private int fourMatched;
    private int fiveMatched;
    private int sixMatched;
    private double purchasedAmount;
    private double yield;
    private long winnings;

    public LottoReport(WinningLotto winners, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            updateMatchedNumberMetrics(winners, lotto);
        }
        updateYield(lottos.size());
    }

    private void updateMatchedNumberMetrics(WinningLotto winners, Lotto test) {
        // TODO: 변경
    }

    private void updateYield(int lottoSize) {
        purchasedAmount = lottoSize * Lotto.PRICE;
        updateWinnings();
        yield = Math.floor((winnings / purchasedAmount) * 100) / 100.0;
    }

    private void updateWinnings() {
        this.winnings = threeMatched * FIFTH.winningMoney +
                fourMatched * FOURTH.winningMoney +
                fiveMatched * THIRD.winningMoney +
                sixMatched * FIRST.winningMoney;
    }

    public int countWinnings(Rank rank){
        return rank.lottoReportMatchedNumGetter.apply(this);
    }

    int threeMatched() {
        return threeMatched;
    }

    int fourMatched() {
        return fourMatched;
    }

    int fiveMatched() {
        return fiveMatched;
    }

    int sixMatched() {
        return sixMatched;
    }

    public double yield() {
        return yield;
    }

}
