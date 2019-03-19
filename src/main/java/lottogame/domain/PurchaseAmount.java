package lottogame.domain;

public class PurchaseAmount {

    static final long LOTTO_PRICE = 1000;

    private long value;

    public PurchaseAmount(long value) {
        if(isInvalid(value)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public long getLottoCount() {
        return value/LOTTO_PRICE;
    }

    static boolean isInvalid(long value) {
        return (value < LOTTO_PRICE || value >= Long.MAX_VALUE);
    }
}