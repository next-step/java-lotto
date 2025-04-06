package autoLotto;

import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public MatchedLottoCount getMatchedNumberCount(WinningLotto winningLotto) {
        int matchedMainCount = (int) numbers.stream()
                                            .filter(winningLotto::containsNumber)
                                            .count();
        boolean isBonusNumber = false;
        if (matchedMainCount == LottoPrize.SECOND.getMatchedCount()) {
            isBonusNumber = numbers.stream()
                                   .anyMatch(winningLotto::containsBonusNumber);

        }
        return new MatchedLottoCount(matchedMainCount, isBonusNumber);
    }

    protected boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public void validate() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("The number of Lotto numbers must be 6.");
        }
        validateNumbersInRange();
    }

    private void validateNumbersInRange() {
        boolean hasInvalidNumber = numbers.stream()
                                          .anyMatch(num -> num < 1 || num > 45);
        if (hasInvalidNumber) {
            throw new IllegalArgumentException("All numbers must be between 1 and 45.");
        }
    }


    @Override
    public String toString() {
        String result = numbers.stream()
                               .sorted()
                               .map(String::valueOf)
                               .collect(Collectors.joining(", "));
        return String.format("[%s]", result);
    }
}
