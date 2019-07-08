package lotto.model;

import java.util.LinkedHashSet;
import java.util.function.Predicate;

public class Lottery {

    private LinkedHashSet<Number> numbers;

    public Lottery(LinkedHashSet<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(LinkedHashSet<Number> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new IllegalArgumentException("로또 번호는 총 6개로 구성이 되어야 합니다.");
        }
    }

    int getWinningCount(LinkedHashSet<Number> winningNumbers) {
        return (int) winningNumbers
                .stream()
                .filter(matchWinningNumbers())
                .count();
    }

    private boolean hasSixNumbers(LinkedHashSet<Number> numbers) {
        return numbers.size() == 6;
    }

    private Predicate<Number> matchWinningNumbers() {
        return winningNumber -> numbers.stream()
                .map(Number::getNumber)
                .anyMatch(e -> e == winningNumber.getNumber());
    }

    boolean isMatchBonusBall(Number bonusBall) {
        return numbers.stream()
                .anyMatch(e -> e.getNumber() == bonusBall.getNumber());
    }

    public LinkedHashSet<Number> getNumbers() {
        return numbers;
    }
}
