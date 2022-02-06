package lotto.domain;


import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<String> numbers;

    public Lotto(final List<String> numbers) {
        numbers.sort(Comparator.comparingInt(Integer::parseInt));
        this.numbers = numbers;
    }

    public int matchNumber(final List<String> winningNumbers) {
        return (int) numbers.stream()
                .filter(n -> winningNumbers.contains(n))
                .count();
    }

    public boolean containsBonusNumber(String bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<String> get() {
        return this.numbers;
    }
}
