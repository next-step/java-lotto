package lotto.domain;

public class CashPayments {
    private int price;
    
    public CashPayments(final int price) {
        this.price = price;
    }
    
    public double getEarningsRate(final long totalPrize) {
        return totalPrize / (double) price;
    }
}
