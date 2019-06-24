package lotto.domain;

public class CashPayments {
    private final static int DEFAULT_PRICE = 1000;
    private int price;
    
    public CashPayments() {
        price = DEFAULT_PRICE;
    }
    
    public CashPayments(int price) {
        this.price = price;
    }
    
    public double getEarningsRate(long totalPrize) {
        return totalPrize / (double) price;
    }
}
