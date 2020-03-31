package lotto;

public enum LottoRule {
    COUNT(6),
    MIN_NUM(1),
    MAX_NUM(45);

    private int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
