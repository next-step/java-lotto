package lotto.domain;

import java.util.Arrays;
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
        Criteria matchedCriteria = new Criteria(0);

        for (Number number : numbers) {
            for (Number winningNumber : winningNumbers.numbers) {
                matchedCriteria = number.matchResult(winningNumber, matchedCriteria);
            }
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
