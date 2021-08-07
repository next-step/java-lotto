package lotto.model;

import lotto.exception.LottoNumberGenerationException;
import lotto.exception.LottoNumberRangeException;

import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.rangeClosed;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_OF_LOTTO_NUMBER = 1;
    public static final int MAX_OF_LOTTO_NUMBER = 45;

    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(toMap(LottoNumber::toInt, identity()));

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        validateContainsKey(number);
        return LOTTO_NUMBERS.get(number);
    }

    public static LottoNumber from(final String number) {
        int parseInt = validateParseInt(number);
        validateContainsKey(parseInt);
        return LOTTO_NUMBERS.get(parseInt);
    }

    private static int validateParseInt(final String number) {
        try {
            return parseInt(number);
        }
        catch (NumberFormatException o_O) {
            throw new LottoNumberGenerationException(o_O.getMessage() + ". please check your input.");
        }
    }

    private static void validateContainsKey(final int parseInt) {
        if (!LOTTO_NUMBERS.containsKey(parseInt)) {
            throw new LottoNumberRangeException();
        }
    }

    public int toInt() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return this.number - o.number;
    }
}
