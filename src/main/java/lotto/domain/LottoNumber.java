package lotto.domain;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String OUT_OF_RANGE_EXCEPTION = "[ERROR] 로또 범위를 벗어난 숫자입니다.";
    private static final String NOT_A_NUMBER_EXCEPTION = "[ERROR] 숫자(또는 구분자)만 입력할 수 있습니다";

    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> LOTTO_NUMBERS.put(number, new LottoNumber(number)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        validateLottoNumber(number);
        return LOTTO_NUMBERS.get(number);
    }

    public static LottoNumber from(final String input) {
        final int number = covertToNumber(input);
        return LottoNumber.from(number);
    }

    private static int covertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_EXCEPTION);
        }
    }

    private static void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }

    public int get() {
        return this.number;
    }
}
