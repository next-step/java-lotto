package lotto.domain.ticket;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS =
            IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                    .boxed()
                    .collect(Collectors.toMap(i -> i, LottoNumber::new));

    private final int number;

    LottoNumber(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("Lotto number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }

        this.number = number;
    }

    public static LottoNumber get(int number) {
        return LOTTO_NUMBERS.get(number);
    }

    private boolean isValidNumber(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
