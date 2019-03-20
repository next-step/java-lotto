package lottogame.domain;

import lottogame.validator.InputValidatable;

public class PurchaseAmount implements InputValidatable<Long> {

    public static final long LOTTO_PRICE = 1000;

    private long value;

    public PurchaseAmount(long value) {
        validate(value);
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public long getLottoCount() {
        return value / LOTTO_PRICE;
    }

    @Override
    public boolean isInvalid(Long target) {
        return target < LOTTO_PRICE || target >= Long.MAX_VALUE;
    }

    @Override
    public String getInvalidMessage() {
        return LOTTO_PRICE + "원 이상의 금액을 입력 해 주세요.";
    }
}