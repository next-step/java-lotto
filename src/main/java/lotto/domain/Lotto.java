package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    Rank checkRank(final List<Integer> winNumbers, final int bonusNumber) {
        int countOfMatch = (int) winNumbers.stream().filter(numbers::contains).count();
        final boolean isMatchBonus = numbers.contains(bonusNumber);

        if (countOfMatch == Rank.FOURTH.getCountOfMatch() && isMatchBonus) {
            countOfMatch = countOfMatch + 1;
        }

        return Rank.findByCountOfMatch(countOfMatch, isMatchBonus);
    }

    public List<Integer> findNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
