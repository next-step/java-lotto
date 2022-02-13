package lotto.domain.user;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoInitInfo {

    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);

    private final int purchasePrice;
    private final int quantity;

    public LottoInitInfo(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.quantity = calculateQuantity(purchasePrice);
    }

    private int calculateQuantity(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE.intValue()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }
        return new BigDecimal(purchasePrice).divide(LOTTO_PRICE, RoundingMode.FLOOR).intValue();
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
