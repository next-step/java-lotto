package lotto;

public class LottoRule {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int PRICE = 1000;

    static int getLottoStartNumber() {
        return LOTTO_START_NUMBER;
    }

    static int getLottoEndNumber() {
        return LOTTO_END_NUMBER;
    }

    public static int getLottoNumbersSize() {
        return LOTTO_NUMBERS_SIZE;
    }

    public static int getPrice() {
        return PRICE;
    }
}
