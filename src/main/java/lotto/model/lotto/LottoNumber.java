package lotto.model.lotto;

import lotto.exception.InvalidLottoNumberException;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private static final int MIN_LOTTO_NUMBER = 1;

    private static final int MAX_LOTTO_NUMBER = 45;

    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber create (int value) {
        lottoNumbers.putIfAbsent(value, new LottoNumber(value));
        return lottoNumbers.get(value);
    }

    private void validate(int value) {
        if (value > MAX_LOTTO_NUMBER || value < MIN_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException(value);
        }
    }

    public boolean isBonusNumber(LottoNumber lottoNumber) {
        return this.equals(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
