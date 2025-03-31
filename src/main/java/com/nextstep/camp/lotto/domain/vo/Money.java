package com.nextstep.camp.lotto.domain.vo;

public class Money {

    private final int value;

    public static final int LOTTO_PRICE = 1000;
    private static final int MIN_VALUE = 0;
    private Money(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value <= MIN_VALUE) {
            throw new IllegalArgumentException("0원 이상 입력해야 합니다.");
        }
        if (isNotDivisibleByLottoPrice(value)) {
            throw new IllegalArgumentException("1000원 단위로 입력해야 합니다.");
        }
    }

    private static boolean isNotDivisibleByLottoPrice(int value) {
        return value % LOTTO_PRICE != 0;
    }

    public static Money of(int value) {
        return new Money(value);
    }

    public int lottoCount() {
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }
}
