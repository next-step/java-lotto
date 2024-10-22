package lotto.domain;

import java.util.Arrays;

public enum LottoWinnersEnum {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    LottoWinnersEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LottoWinnersEnum findByValue(int value) {
        return Arrays.stream(LottoWinnersEnum.values())
                .filter(item -> item.getValue() == value)
                .findFirst()
                .orElseThrow(null);
    }

}
