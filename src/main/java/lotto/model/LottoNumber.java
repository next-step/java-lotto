package lotto.model;

import lotto.exception.WrongNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static lotto.common.LottoConstants.*;

public class LottoNumber {
    private static final String NUMERIC_CHECK_REGEX = "-?\\d+(\\.\\d+)?";

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
        validateNumeric(number);
        return valueOf(Integer.parseInt(number));
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER) {
            throw new WrongNumberException(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
        }
    }

    private static void validateNumeric(String lottoNumber) {
        if (!lottoNumber.matches(NUMERIC_CHECK_REGEX)) {
            throw new WrongNumberException();
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
