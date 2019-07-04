package lotto.enumset;

public enum InitEnum {

    LOTTO_DEFAULT_SIZE(6),
    LOTTO_DEFAULT_PRICE(1000),
    LOTTO_DEFAULT_WINNER_TYPE(5);

    private int numValue;

    InitEnum(int numValue) {
        this.numValue = numValue;
    }

    public int value() {
        return this.numValue;
    }

}
