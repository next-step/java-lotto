package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static lotto.common.LottoConstants.*;

public class LottoNumber {
    private final int number;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(lottoNumberIndex -> lottoNumbers.put(lottoNumberIndex, new LottoNumber(lottoNumberIndex)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber lottoNumber(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        validateLottoNumber(lottoNumber);
        return lottoNumber;
    }

    public static LottoNumber lottoNumber(String number) {
        int lottoNumber;

        try {
            lottoNumber = Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(WRONG_INPUT_NUMBER);
        }

        return lottoNumber(lottoNumber);
    }

    private static void validateLottoNumber(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
        }
    }

    public int number() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
