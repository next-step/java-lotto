package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class LottoStatistics {

    private int[] winCounts;
    private double winPercent;

    public LottoStatistics() {
        int winType = Rank.countRankType();
        this.winCounts = new int[winType];
        this.winPercent = 0;
    }

    public void updateWinCounts(Rank rank) {
        this.winCounts[rank.getWinOrder()]++;
    }

    public void updateWinPercent(BigDecimal consume) {
        BigDecimal income = new BigDecimal(calculateIncome());

        this.winPercent = income.divide(consume, 4, RoundingMode.FLOOR)
                .multiply(new BigDecimal(100))
                .doubleValue();
    }

    private int calculateIncome() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getWinMoney() * winCounts[rank.getWinOrder()])
                .sum();
    }

    public int[] getWinCounts() {
        return winCounts.clone();
    }

    public double getWinPercents() {
        return winPercent;
    }
}
