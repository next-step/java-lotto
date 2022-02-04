package lotto.domain;


import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<String> numbers;

    public Lotto(List<String> numbers) {
        numbers.sort(Comparator.comparingInt(Integer::parseInt));
        this.numbers = numbers;
    }

    public List<String> get() {
        return this.numbers;
    }

    public int matchNumber(List<String> winningNumbers) {
        return (int) numbers.stream()
            .filter(n -> winningNumbers.contains(n))
            .count();
    }

    public boolean containsBonusNumber(String bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
