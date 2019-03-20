package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Price {
    private static final int ONE_TICKET_PRICE = 1_000;

    private int totalAmount;

    public Price(int amount) {
        totalAmount = amount;
    }

    public int ticketCount() {
        return totalAmount / ONE_TICKET_PRICE;
    }

    public BigDecimal totalRateByWinning(BigDecimal totalAmountByWinning) {
        return totalAmountByWinning.divide(BigDecimal.valueOf(totalAmount), 2, RoundingMode.HALF_UP);
    }
}
