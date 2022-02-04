package lotto.domain;


import java.util.Arrays;
import java.util.Objects;

public enum WinningPrice {
    THREE(3, 0, 5000),
    FOUR(4, 0, 50000),
    Five(5, 0, 1500000),
    FiveWithBonus(5, 1, 30000000),
    Six(6, 0, 2000000000),
    OTHERS(0, 0, 0);

    private final int winNumber;
    private int bonus = 0;
    private final int currency;

    WinningPrice(final int winNumber, int bonus, final int currency) {
        this.winNumber = winNumber;
        if (winNumber == 5) {
            this.bonus = bonus;
        }
        this.currency = currency;
    }

    public static WinningPrice of(final int winNumber, final int bonus) {
        return Arrays.stream(values())
            .filter(WinningPrice -> and(
                Objects.equals(WinningPrice.winNumber, winNumber),
                Objects.equals(WinningPrice.bonus, bonus))
            ).findAny()
            .orElse(OTHERS);
    }

    private static boolean and(boolean equals, boolean equals1) {
        return equals && equals1;
    }

    public int operate(final int count) {
        return currency * count;
    }
}
