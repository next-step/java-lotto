package lotto;

public enum LottoRule {
    COUNT(6);

    private int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
