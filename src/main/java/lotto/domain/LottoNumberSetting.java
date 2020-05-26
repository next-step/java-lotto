package lotto.domain;

public enum LottoNumberSetting {
    BEGIN_BOUND(1),
    END_BOUND(45),
    COUNT_OF_BALL(6);

    private final int value;

    LottoNumberSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
