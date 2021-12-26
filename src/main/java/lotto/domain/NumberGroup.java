package lotto.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class NumberGroup {
    public static final int LIMIT = 6;
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

        int matchResult = 0;
        while (thisNumberIterator.hasNext() && winningNumberIterator.hasNext()) {
            matchResult = matchResult(thisNumberIterator.next(), winningNumberIterator.next(), matchResult);
        }
        matchMatchCriteria(matchResult);
    }

    public int matchResult(Number thisNumber, Number winningNumber, int matchResult) {
        if (thisNumber.equals(winningNumber)) {
            matchResult++;
        }
        return matchResult;
    }

    public void matchMatchCriteria(int result) {
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
