package lotto.model;

import lotto.exception.WrongNumberException;

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
        return valueOf(validateAndParseInt(number));
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER) {
            throw new WrongNumberException(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
        }
    }

    private static int validateAndParseInt(String lottoNumber) {
        int number;

        try {
            number = Integer.parseInt(lottoNumber);
        } catch (Exception e) {
            throw new WrongNumberException();
        }

        return number;
    }

    public boolean isSameNumber(String numberString) {
        return this.number == Integer.parseInt(numberString);
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public int number() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
