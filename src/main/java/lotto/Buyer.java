package lotto;

import java.math.BigDecimal;

public class Buyer {
    private static final String PURCHASE_EXCEPTION_MESSAGE = "구입금액은 1000원 이상의 금액을 " +
            "입력해야 합니다.";

    private LottoPrice lottoPrice = new LottoPrice();
    private int purchase;
    private BigDecimal purchaseDecimal;

    public Buyer(int purchase) {
        validatePurchase(purchase);
        this.purchase = purchase;
    }

    public int buyLotto() {
        purchaseDecimal = new BigDecimal(this.purchase);
        return (purchaseDecimal.divide(lottoPrice.getLottoPrice())).intValue();
    }

    private void validatePurchase(int purchase) {
        if (purchase < lottoPrice.getLottoPrice().intValue()) {
            throw new IllegalArgumentException(PURCHASE_EXCEPTION_MESSAGE);
        }
    }
}
