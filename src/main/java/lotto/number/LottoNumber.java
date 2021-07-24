package lotto.number;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN_OF_LOTTO_NUMBER = 1;
    public static final int MAX_OF_LOTTO_NUMBER = 45;

    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS =
            IntStream.rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toMap(LottoNumber::toInt, Function.identity()));

    private final int number;

    private LottoNumber(int number) {
        validate(number);

        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_OF_LOTTO_NUMBER || number > MAX_OF_LOTTO_NUMBER) {
            throwIllegalArgumentException();
        }
    }

    public static LottoNumber from(int number) {
        if (!LOTTO_NUMBERS.containsKey(number)) {
            throwIllegalArgumentException();
        }

        return LOTTO_NUMBERS.get(number);
    }

    private static void throwIllegalArgumentException() {
        throw new IllegalArgumentException(
                "Lotto number must be greater than " + MIN_OF_LOTTO_NUMBER + " and less than " + MAX_OF_LOTTO_NUMBER
        );
    }

    public int toInt() {
        return number;
    }
}
