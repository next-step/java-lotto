package lotto.domain.winning;

import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.PurchaseAmount;

public class WinningStatistic {

    private final int[] gradeCounts = new int[Grade.values().length];

    private PurchaseAmount purchaseAmount;

    public WinningStatistic(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getGradeCount(Grade grade) {
        return gradeCounts[grade.ordinal()];
    }

    public void calculateWinningStatistic(Grade grade) {
        gradeCounts[grade.ordinal()]++;
    }

    public double calculateProfitRate() {
        int totalWinningAmount =
            (firstGradeCount * Grade.FIRST_GRADE.getPrizeMoney()) +
                (secondGradeCount * Grade.SECOND_GRADE.getPrizeMoney()) +
                (thirdGradeCount * Grade.THIRD_GRADE.getPrizeMoney()) +
                (forthGradeCount * Grade.FOUR_GRADE.getPrizeMoney());
        double profitRate = (double) totalWinningAmount / purchaseAmount.getPurchaseAmount();
        return Double.parseDouble(formattedProfitRate(Math.floor(profitRate * 100) / 100));
    }

    private String formattedProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(profitRate);
    }
}
