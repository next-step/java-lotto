package lotto.step2;

import java.math.BigDecimal;

public class Money {
    private long money;
    private static final long PRICE_PER_LOTTO = 1000;
    private static final int SCALE = 2;
    private static final String INVALID_COST = "구매 금액은 1000원 이상이어야 합니다.";

    public Money(String money){
        this(Integer.parseInt(money));
    }

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public void validateMoney(int money) {
        if (money < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(INVALID_COST);
        }
    }

    public long LottoCount() {
        return (money / PRICE_PER_LOTTO);
    }

    public double profits(long sum){
        BigDecimal purchasingAmount = BigDecimal.valueOf(money);
        return BigDecimal.valueOf(sum)
                    .divide(purchasingAmount,SCALE,BigDecimal.ROUND_DOWN)
                    .doubleValue();
    }

}
