package lotto.domain;

public class LottoAmount {
    private int value;
    public LottoAmount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("로또의 개수는 0 이상이어야 합니다.");
        }
    }

    public boolean isNotEqual(int i) {
        return this.value != i;
    }

    public int getValue() {
        return this.value;
    }

    public boolean biggerThanZero() {
        return this.value > 0;
    }
}
