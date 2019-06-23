package lotto.domain;

import lotto.common.ErrorMessage;

public class LottoPrice {
    private static final int DEFAULT_PRICE = 1000;
    private static final int CANT_BUYABLE_COUNT = 0;
    private int price;
    
    
    public LottoPrice() {
        price = DEFAULT_PRICE;
    }
    
    
    public int getBuyableCount(int cashPayment) {
        int buyableCount = cashPayment / price;
        if (buyableCount <= CANT_BUYABLE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
        }
        
        return buyableCount;
    }
}
