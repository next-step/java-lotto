package lotto.domain;

import java.lang.ref.SoftReference;

public class Fee {

    private static final int PRICE_PER_GAME = 1000;

    private int value;

    public Fee(int fee) {
        this.value = fee;
    }

    public int convertToGameUnit() {
        return value/PRICE_PER_GAME;
    }
}
