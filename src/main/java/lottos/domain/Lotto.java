package lottos.domain;

import lottos.domain.exceptions.LottoDuplicationNumberException;
import lottos.domain.numbers.Numbers;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private final Numbers numbers;

    public Lotto(final List<Integer> numbers) {
        checkDuplicateNumbers(numbers);
        this.numbers = Numbers.valueOf(numbers);
    }

    private void checkDuplicateNumbers(final List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new LottoDuplicationNumberException();
        }
    }

    public Lotto(final Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
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
