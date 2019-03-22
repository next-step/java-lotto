package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = new HashMap<>();

    private final int number;

    LottoNumber(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("Lotto number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }

        this.number = number;
    }

    public static LottoNumber get(int number) {
        LottoNumber lottoNumber = LOTTO_NUMBERS.get(number);
        return ((null == lottoNumber) ? put(number) : lottoNumber);
    }

    private static LottoNumber put(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        LOTTO_NUMBERS.put(number, lottoNumber);

        return lottoNumber;
    }

    private boolean isValidNumber(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
