package domain;

import java.math.BigDecimal;

public class Price {
    private static final int ONE_TICKET_PRICE = 1000;

    private int totalAmount;

    public Price(int amount) {
        totalAmount = amount;
    }

    public int ticketCount() {
        return totalAmount / ONE_TICKET_PRICE;
    }

    public BigDecimal totalRateByWinning(BigDecimal totalAmountByWinning) {
        BigDecimal test = totalAmountByWinning.divide(BigDecimal.valueOf(totalAmount));
        return test;
    }
}
