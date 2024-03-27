package lotto.domain;

import java.lang.ref.SoftReference;

public class Fee {

    private static final int PRICE_PER_GAME = 1000;

    private int value;

    public Fee(int fee) {
        validate(fee);
        this.value = fee;
    }

    private void validate(int fee) {
        if (fee < PRICE_PER_GAME) {
            throw new RuntimeException("한 게임당 1000원 입니다. 입력 금액을 확인 해주세요.");
        }
    }

    public int convertToGameUnit() {
        return value/PRICE_PER_GAME;
    }

    public int getValue() {
        return value;
    }
}
