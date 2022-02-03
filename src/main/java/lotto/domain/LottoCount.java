package lotto.domain;

public class LottoCount {

    private static final int LOTTO_PRICE = 1_000;

    private int lottoCount;

    public LottoCount(int value) {
        validateValue(value);
        this.lottoCount = value / LOTTO_PRICE;
    }

    private void validateValue(int value) {
        if (valueNotPurchasable(value)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean valueNotPurchasable(int value) {
        return value < LOTTO_PRICE || value % LOTTO_PRICE != 0;
    }

    public int count() {
        return lottoCount;
    }
}
