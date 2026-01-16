package lotto.domain;

public class LottoCount {
    private static final long LOTTO_PRICE = 1_000;
    private final int value;

    public LottoCount(Money money) {
        this((int) (money.getMoney() / LOTTO_PRICE));
    }

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