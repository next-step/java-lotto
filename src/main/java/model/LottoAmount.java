package model;

import java.math.BigDecimal;

public class LottoAmount {

    private static final int LOTTO_PURCHASE_UNIT = 1000;

    private final int amount;

    public LottoAmount(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int calculateLottoPurchaseCount() {
        return amount / LOTTO_PURCHASE_UNIT;
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(amount);
    }

    private void validate(final int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("로또 구매 가능한 금액은 0원 이상어야합니다.");
        }

        if (amount % LOTTO_PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException("로또 구매를 위한 금액은 1000단위여야 합니다.");
        }
    }
}
