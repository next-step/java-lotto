package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "숫자의 범위는 %d ~ %d 사이의 값입니다.";
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = numbers();

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateLottoNumber(number);
        return LOTTO_NUMBERS.get(number);
    }

    private static void validateLottoNumber(int number) {
        if (LOTTO_NUMBERS.get(number) == null) {
            throw new IllegalArgumentException(String.format(LOTTO_NUMBER_RANGE_ERROR_MESSAGE, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    public static LottoNumber of(String text) {
        return of(Integer.parseInt(text));
    }

    private static Map<Integer, LottoNumber> numbers() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toMap(number -> number, LottoNumber::new));
    }

    public int toInt() {
        return this.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
