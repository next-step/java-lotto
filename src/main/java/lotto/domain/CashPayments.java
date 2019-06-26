package lotto.domain;

public class CashPayments {
    private int price;
    private int buyableCount;
    
    public CashPayments(final int price) {
        this.price = price;
    }
    
    public double getEarningsRate(final long totalPrize) {
        return totalPrize / (double) price;
    }
    
    public int getBuyableCount(int defaultPrice) {
        return price / defaultPrice;
    }
}
