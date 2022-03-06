package lotto.domain.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoPurchase {
    public static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);

    private final BigDecimal handLottoQuantity;
    private final BigDecimal automaticLottoQuantity;

    public LottoPurchase(int money, int handLottoQuantity) {
        validateMoney(new BigDecimal(money), new BigDecimal(handLottoQuantity));
        this.handLottoQuantity = new BigDecimal(handLottoQuantity);
        this.automaticLottoQuantity = calculateAutomaticLottoQuantity(new BigDecimal(money));
    }

    private void validateMoney(BigDecimal money, BigDecimal handLottoQuantity) {
        if(money.compareTo(LOTTO_PRICE) < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }

        if(money.compareTo(handLottoQuantity.multiply(LOTTO_PRICE)) < 0){
            throw new IllegalArgumentException("[ERROR] 금액이 모자라 수동 로또를 살 수 없습니다.");
        }
    }

    private BigDecimal calculateAutomaticLottoQuantity(BigDecimal money) {
        return money.subtract(handLottoQuantity.multiply(LOTTO_PRICE)).divide(LOTTO_PRICE, RoundingMode.FLOOR);
    }

    public BigDecimal getHandLottoQuantity() {
        return handLottoQuantity;
    }

    public BigDecimal getAutomaticLottoQuantity() {
        return automaticLottoQuantity;
    }
}
