package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitMargin {

    int winningAmount;
    int purchaseAmount;

    public ProfitMargin(int winningAmount, int purchaseAmount) {
        this.winningAmount = winningAmount;
        this.purchaseAmount = purchaseAmount;
    }

    public void printMargin() {
        double profitMargin = calculateMargin();
        System.out.println("총 수익률은 " + profitMargin + "입니다.");
    }

    public double calculateMargin() {
        return new BigDecimal(winningAmount)
                .divide(new BigDecimal(purchaseAmount), 2, RoundingMode.FLOOR)
                .doubleValue();
    }
}
