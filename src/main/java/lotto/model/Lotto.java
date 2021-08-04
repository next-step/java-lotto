package lotto.model;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Math.toIntExact;
import static java.util.stream.Collectors.toList;

public class Lotto {
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
        return new Lotto(LottoNumber.aggregate(string));
    }

    public int getMatchCount(final Collection<LottoNumber> winningNumber) {
        return toIntExact(winningNumber.stream()
                                       .filter(numbers::contains)
                                       .count());
    }

    public boolean isMatchBonus(final LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
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
