package lotto.view;

import lotto.domain.BuyableCount;
import lotto.domain.CashPayments;

public class LottoPayment {
    private final static int DEFAULT_PRICE = 1_000;
    
    private final int price;
    
    public LottoPayment() {
        this(DEFAULT_PRICE);
    }
    
    public LottoPayment(int price) {
        this.price = price;
    }
    
    public BuyableCount getBuyableCount(CashPayments cashPayments) {
        return new BuyableCount(cashPayments.getBuyableCount(price));
    }
}
