package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int matchNumbers(List<Integer> winningNumbers) {
        return (int) IntStream.range(0, winningNumbers.size())
                .parallel()
                .filter(i -> numbers.contains(winningNumbers.get(i)))
                .count();
    }
}
