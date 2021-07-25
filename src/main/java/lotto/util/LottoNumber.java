package lotto.util;

public class LottoNumber {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private LottoNumber() {
    }

    public static boolean isValidLottoNumber(int number) {
        return number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER;
    }
}
