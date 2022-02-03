package lotto.domain;


import java.util.Arrays;

public enum WinningPrice {

    THREE(3, 0, 5000),
    FOUR(4, 0, 50000),
    Five(5, 0, 1500000),
    FiveWithBonus(5, 1, 30000000),
    Six(6, 0, 2000000000),
    OTHERS(0,0,0);

    private final int count;
    private final int bonus;
    private final int currency;

    WinningPrice(final int count, final int bonus, final int currency) {
        this.count = count;
        this.bonus = bonus;
        this.currency = currency;
    }

    public int getCurrency() {
        return this.currency;
    }

    public static WinningPrice of(final int count, final int bonus) {
        return Arrays.stream(values()).filter(winningPrice -> winningPrice.count == count).findAny().orElse(WinningPrice.OTHERS);

    }
}
