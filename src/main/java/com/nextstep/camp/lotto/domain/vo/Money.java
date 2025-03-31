package com.nextstep.camp.lotto.domain.vo;

public class Money {
    public static final int LOTTO_PRICE = 1000;

    private final int value;

    public Money(int value) {
        if (value <= 0 || value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해야 합니다.");
        }
        this.value = value;
    }

    public int lottoCount() {
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }
}
