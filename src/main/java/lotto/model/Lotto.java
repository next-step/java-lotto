package lotto.model;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Math.toIntExact;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Lotto {
    private final Set<LottoNumber> numbers;

    private static final String DELIMITER = ", ";

    public static final int NUMBER_OF_LOTTO_COUNT = 6;

    private Lotto(final Collection<LottoNumber> numbers) {
        this.numbers = new TreeSet<>(numbers);
    }

    public static Lotto from(final Collection<LottoNumber> numbers) {
        Objects.requireNonNull(numbers, "numbers must be not null.");
        return new Lotto(numbers);
    }

    public static Lotto from(final String string) {
        Objects.requireNonNull(string, "numbers must be not null.");
        return new Lotto(aggregate(string));
    }

    private static Set<LottoNumber> aggregate(final String winningNumber) {
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

    public int getMatchCount(Lotto winningLotto) {
        return toIntExact(winningLotto.numbers.stream()
                                              .filter(this::contains)
                                              .count());
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.stream()
                      .map(LottoNumber::toInt)
                      .map(Objects::toString)
                      .collect(toList())
                      .toString();
    }
}
