package lotto.domain;

public enum Prize {
    SIX(2000000000),
    FIVE(1500000),
    FOUR(50000),
    THREE(5000);

    private final int value;

    Prize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
