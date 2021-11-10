package lotto.vo;

public enum LottoRule {

    START_NUMBER(1),
    END_NUMBER(45),
    LOTTO_COUNT(6);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
