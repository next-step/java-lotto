package lotto.domain;

import java.util.List;

import static lotto.domain.Rank.*;

public class LottoReport {
    private int fifthCount;
    private int fourthCount;
    private int thirdCount;
    private int secondCount;
    private int firstCount;
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
        int countOfMatch = test.matchCountWith(winners);
        boolean matchBonus = test.matchBonus(winners.bonusNumber);
        FIFTH.ifMatchedThan(countOfMatch, matchBonus, () -> fifthCount++);
        FOURTH.ifMatchedThan(countOfMatch, matchBonus, () -> fourthCount++);
        THIRD.ifMatchedThan(countOfMatch, matchBonus, () -> thirdCount++);
        SECOND.ifMatchedThan(countOfMatch, matchBonus, () -> secondCount++);
        FIRST.ifMatchedThan(countOfMatch, matchBonus, () -> firstCount++);
    }

    private void updateYield(int lottoSize) {
        purchasedAmount = lottoSize * Lotto.PRICE;
        updateWinnings();
        yield = Math.floor((winnings / purchasedAmount) * 100) / 100.0;
    }

    private void updateWinnings() {
        this.winnings = fifthCount * FIFTH.winningMoney +
                fourthCount * FOURTH.winningMoney +
                thirdCount * THIRD.winningMoney +
                secondCount * SECOND.winningMoney +
                firstCount * FIRST.winningMoney;
    }

    public int countWinnings(Rank rank) {
        return rank.lottoReportMatchedNumGetter.apply(this);
    }

    int fifthCount() {
        return fifthCount;
    }

    int fourthCount() {
        return fourthCount;
    }

    int thirdCount() {
        return thirdCount;
    }

    int secondCount() {
        return secondCount;
    }

    int firstCount() {
        return firstCount;
    }

    public double yield() {
        return yield;
    }

}
