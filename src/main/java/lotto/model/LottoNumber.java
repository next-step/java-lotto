package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE = "로또 번호는 1 ~ 45 까지 입니다.";

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
