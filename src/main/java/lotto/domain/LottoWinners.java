package lotto.domain;

import java.util.Arrays;

public enum LottoWinners {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    LottoWinners(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LottoWinners findByValue(int value) {
        return Arrays.stream(LottoWinners.values())
                .filter(item -> item.getValue() == value)
                .findFirst()
                .orElseThrow(null);
    }

}
