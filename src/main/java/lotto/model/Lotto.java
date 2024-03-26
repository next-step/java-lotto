package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = Numbers.valueOf(numbers);
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public int matchNumbers(List<Integer> winningNumbers) {
        return (int) IntStream.range(0, winningNumbers.size())
                .parallel()
                .filter(i -> numbers.contains(winningNumbers.get(i)))
                .count();
    }
}
