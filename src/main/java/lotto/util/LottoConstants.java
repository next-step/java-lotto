package lotto.util;

public class LottoConstants {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final int LOTTO_MAX_SIZE = 6;

    private LottoConstants() {}

    public static int getLottoMinNumber() {
        return LOTTO_MIN_NUMBER;
    }

    public static int getLottoMaxNumber() {
        return LOTTO_MAX_NUMBER;
    }

    public static int getLottoMaxSize() {
        return LOTTO_MAX_SIZE;
    }
}
