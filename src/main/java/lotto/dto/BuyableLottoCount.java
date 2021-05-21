package lotto.dto;

import static lotto.domain.LottoPrice.LOTTO_PRICE;

public class BuyableLottoCount {

    private int value;


    private BuyableLottoCount(int value) {
        this.value = value;
    }

    public boolean isHigher(int comparingValue) {
        return value > comparingValue;
    }

    public static BuyableLottoCount calculateBuyableCount(PaymentMoney paymentMoney) {
        int result = paymentMoney.getValue() / LOTTO_PRICE;
        return new BuyableLottoCount(result);
    }
}
