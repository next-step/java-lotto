package study.step2.domain.dto;

import study.step2.domain.exception.LottoException;

public class PurchaseAmount {

    public static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (isValidAmount(amount)) {
            throw new LottoException("구입 금액이 부족합니다.");
        }
    }

    private boolean isValidAmount(int amount) {
        return amount < LOTTO_PRICE;
    }

    public int numberOfLottos() {
        return amount / LOTTO_PRICE;
    }

    public int amount() {
        return amount;
    }
}
