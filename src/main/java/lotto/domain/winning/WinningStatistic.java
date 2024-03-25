package lotto.domain.winning;

import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.PurchaseAmount;

public class WinningStatistic {

    private final int[] gradeCounts = new int[Grade.values().length];

    private final PurchaseAmount purchaseAmount;

    public WinningStatistic(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getGradeCount(final Grade grade) {
        return gradeCounts[grade.ordinal()];
    }

    public void calculateWinningStatistic(final Grade grade) {
        gradeCounts[grade.ordinal()]++;
    }

    public double calculateProfitRate() {
        double profitRate =
            (double) calculateTotalWinningAmount() / purchaseAmount.getPurchaseAmount();
        return Double.parseDouble(formattedProfitRate(Math.floor(profitRate * 100) / 100));
    }

    private int calculateTotalWinningAmount() {
        return Arrays.stream(Grade.values())
            .mapToInt(grade -> gradeCounts[grade.ordinal()] * grade.getPrizeMoney())
            .sum();
    }

    private String formattedProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(profitRate);
    }
}
