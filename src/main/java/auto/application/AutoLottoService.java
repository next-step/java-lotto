package auto.application;

import java.math.BigDecimal;

public class AutoLottoService {
    private static final int LOTTO_PRICE = 1000;

    public int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static BigDecimal getReturnRate(int totalAmount, int amount) {
        return BigDecimal.valueOf(totalAmount)
                         .divide(BigDecimal.valueOf(amount));
    }
}
