package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MarginAmount {
    int marginAmount;
    public MarginAmount(int resultMarginAmount) {
        marginAmount = resultMarginAmount;
    }

    public double calculateMarginPercent(int purchaseAmount) {
        return new BigDecimal(marginAmount)
                .divide(new BigDecimal(purchaseAmount), 2, RoundingMode.FLOOR)
                .doubleValue();
    }
}
