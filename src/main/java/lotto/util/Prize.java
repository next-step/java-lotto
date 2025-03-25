package lotto.util;

public enum Prize {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int number;
    private final int money;

    Prize(int number, int money) {
        this.number = number;
        this.money = money;
    }

    public int number() {
        return  number;
    }

    public int money() {
        return money;
    }
}
