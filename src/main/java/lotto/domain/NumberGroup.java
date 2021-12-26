package lotto.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class NumberGroup {
    private final List<Number> numbers;

    public NumberGroup(List<Number> numbers) {
        this.numbers = numbers;
    }

    public boolean appropriate(int count) {
        return numbers.size() == count;
    }

    public void match(NumberGroup winningNumbers) {
        Iterator<Number> thisNumberIterator = numbers.iterator();
        Iterator<Number> winningNumberIterator = winningNumbers.numbers.iterator();

        Criteria matchedCriteria = new Criteria(0);
        while (thisNumberIterator.hasNext() && winningNumberIterator.hasNext()) {
            matchedCriteria = thisNumberIterator.next().matchResult(winningNumberIterator.next(), matchedCriteria);
        }
        matchMatchCriteria(matchedCriteria);
    }

    public void matchMatchCriteria(Criteria result) {
        Arrays.stream(MatchCriteria.values())
                .filter(m -> m.equalsCriteria(result))
                .findFirst()
                .ifPresent(MatchCriteria::match);
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberGroup)) return false;
        NumberGroup that = (NumberGroup) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
