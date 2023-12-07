package lotto.model;

public enum LottoEnum {
    LOW_BOUND(1),
    MAX_BOUND(45),
    LOTTO_SIZE(6);

    private final int value;

    LottoEnum(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
