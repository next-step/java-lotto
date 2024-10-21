package lotto.domain;

import lotto.ui.PrintView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitMargin {

    private int winningAmount;
    private int purchaseAmount;

    public ProfitMargin(int winningAmount, int purchaseAmount) {
        this.winningAmount = winningAmount;
        this.purchaseAmount = purchaseAmount;
    }

    public void printMargin() {
        PrintView.printMargin(calculateMargin());
    }

    public double calculateMargin() {
        return new BigDecimal(winningAmount)
                .divide(new BigDecimal(purchaseAmount), 2, RoundingMode.FLOOR)
                .doubleValue();
    }
}
