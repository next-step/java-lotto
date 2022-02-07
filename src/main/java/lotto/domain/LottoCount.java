package lotto.domain;

public class LottoCount {

    private static final int LOTTO_PRICE = 1_000;

    private int lottoCount;

    public LottoCount(int count) {
        validateCount(count);
        this.lottoCount = count / LOTTO_PRICE;
    }

    public int count() {
        return lottoCount;
    }

    private void validateCount(int count) {
        if (valueNotPurchasable(count)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean valueNotPurchasable(int value) {
        return value < LOTTO_PRICE || value % LOTTO_PRICE != 0;
    }
}
