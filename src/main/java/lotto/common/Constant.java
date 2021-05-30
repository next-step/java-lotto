package lotto.common;

public enum Constant {
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
