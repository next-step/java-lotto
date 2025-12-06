package lotto.domain;

public class LottoCount {
    private final int value;

    public LottoCount(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int value() {
        return value;
    }
}