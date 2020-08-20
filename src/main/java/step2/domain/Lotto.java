package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> findWinningNumbers(List<Integer> winningNumbers) {
        return numbers.stream()
                .filter(number -> winningNumbers.contains(number))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
