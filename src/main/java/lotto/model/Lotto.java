package lotto.model;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Lotto {
    private static final String DELIMITER = ", ";

    private static final int NUMBER_OF_LOTTO_COUNT = 6;

    private final Set<LottoNumber> numbers;

    private Lotto(final Collection<LottoNumber> numbers) {
        this.numbers = new TreeSet<>(numbers);
    }

    public static Lotto from(final Collection<LottoNumber> numbers) {
        Objects.requireNonNull(numbers, "numbers must be not null.");
        return new Lotto(numbers);
    }

    public static Lotto from(final TreeSet<LottoNumber> numbers) {
        Objects.requireNonNull(numbers, "numbers must be not null.");
        return new Lotto(numbers);
    }

    public static Lotto from(final String string) {
        Objects.requireNonNull(string, "numbers must be not null.");
        return new Lotto(parseIntegerSet(string));
    }

    private static Set<LottoNumber> parseIntegerSet(final String winningNumber) {
        return stream(winningNumber.split(DELIMITER))
                .map(LottoNumber::from)
                .collect(toSet());
    }

    public LottoPrize scratch(final WinningLotto winningLotto) {
        Objects.requireNonNull(winningLotto, "winningLotto must be not null.");
        return LottoPrize.findByMatchCount(winningLotto.matchCount(this));
    }

    public boolean isSizeValid() {
        return numbers.size() == NUMBER_OF_LOTTO_COUNT;
    }

    public int matchCount(Lotto winningLotto) {
        return (int) winningLotto.numbers.stream()
                                         .filter(numbers::contains)
                                         .count();
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
