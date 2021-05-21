package lotto.domain;

import java.util.List;

public class LottoReport {
    public static final int METRIC_COUNT_THREE = 3;
    public static final int METRIC_COUNT_FOUR = 4;
    public static final int METRIC_COUNT_FIVE = 5;
    public static final int METRIC_COUNT_SIX = 6;
    public static final int WINNINGS_FOR_THREE_MATCHED = 5000;
    public static final int WINNINGS_FOR_FOUR_MATCHED = 50000;
    public static final int WINNINGS_FOR_FIVE_MATCHED = 1500000;
    public static final int WINNINGS_FOR_SIX_MATCHED = 2000000000;
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
        if (matched == METRIC_COUNT_THREE) {
            threeMatched++;
        }
        if (matched == METRIC_COUNT_FOUR) {
            fourMatched++;
        }
        if (matched == METRIC_COUNT_FIVE) {
            fiveMatched++;
        }
        if (matched == METRIC_COUNT_SIX) {
            sixMatched++;
        }
    }

    private void updateYield(int lottoSize) {
        purchasedAmount = lottoSize * Lotto.PRICE;
        updateWinnings();
        yield = Math.floor((winnings / purchasedAmount) * 100) / 100.0;
    }

    private void updateWinnings() {
        this.winnings = threeMatched * WINNINGS_FOR_THREE_MATCHED +
                fourMatched * WINNINGS_FOR_FOUR_MATCHED +
                fiveMatched * WINNINGS_FOR_FIVE_MATCHED +
                sixMatched * WINNINGS_FOR_SIX_MATCHED;
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
