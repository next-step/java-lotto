package lotto.model;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String DELIMITER = ", ";

    public static final int MIN_OF_LOTTO_NUMBER = 1;
    public static final int MAX_OF_LOTTO_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_COUNT = 6;

    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(toMap(LottoNumber::toInt, identity()));

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        validate(number);
        return LOTTO_NUMBERS.get(number);
    }

    public static LottoNumber from(final String number) {
        int parseInt = parseInt(number);
        validate(parseInt);
        return LOTTO_NUMBERS.get(parseInt);
    }

    private static void validate(final int number) {
        if (!LOTTO_NUMBERS.containsKey(number)) {
            throw new IllegalArgumentException("lotto number must be greater than " + MIN_OF_LOTTO_NUMBER + " and less than " + MAX_OF_LOTTO_NUMBER);
        }
    }

    public int toInt() {
        return number;
    }

    public static Set<LottoNumber> aggregate(final String winningNumber) {
        Set<LottoNumber> lottoNumbers = stream(winningNumber.split(DELIMITER))
                .map(LottoNumber::from)
                .collect(toSet());

        validateAggregate(lottoNumbers);

        return lottoNumbers;
    }

    private static void validateAggregate(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_OF_LOTTO_COUNT) {
            throw new IllegalArgumentException("Set<LottoNumber> size must be " + NUMBER_OF_LOTTO_COUNT);
        }
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
