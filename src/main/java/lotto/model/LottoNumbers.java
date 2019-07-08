package lotto.model;

import java.util.LinkedHashSet;
import java.util.function.Predicate;

public class LottoNumbers {

    private LinkedHashSet<Number> numbers;

    public LottoNumbers(LinkedHashSet<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(LinkedHashSet<Number> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new IllegalArgumentException("로또 번호는 총 6개로 구성이 되어야 합니다.");
        }
    }

    int getWinningCount(LottoNumbers winningNumbers) {
        return (int) winningNumbers
                .getNumbers()
                .stream()
                .filter(matchWinningNumbers())
                .count();
    }

    private boolean hasSixNumbers(LinkedHashSet<Number> numbers) {
        return numbers.size() == 6;
    }

    private Predicate<Number> matchWinningNumbers() {
        return winningNumber -> numbers.stream()
                .map(Number::getValue)
                .anyMatch(e -> e == winningNumber.getValue());
    }

    public boolean hasNumber(Number number) {
        return numbers.stream()
                .anyMatch(e -> e.getValue() == number.getValue());
    }

    public LinkedHashSet<Number> getNumbers() {
        return numbers;
    }
}
