package lotto.domain;


import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String OUT_OF_RANGE_EXCEPTION = "[ERROR] 로또 범위를 벗어난 숫자입니다.";

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private final int number;

    private LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        if (!lottoNumbers.containsKey(number)) {
            lottoNumbers.put(number, new LottoNumber(number));
        }
        return lottoNumbers.get(number);
    }

    private void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }

    public int get() {
        return this.number;
    }
}
