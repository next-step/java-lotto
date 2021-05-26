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

    public static LottoNumber valueOf(int number) {
        validateLottoNumber(number);
        return lottoNumbers.get(number);
    }

    public static LottoNumber valueOf(String number) {
        int lottoNumber;

        try {
            lottoNumber = Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(WRONG_INPUT_NUMBER);
        }

        return valueOf(lottoNumber);
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER) {
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
