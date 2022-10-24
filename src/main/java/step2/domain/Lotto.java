package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        List<Integer> sourceNumbers = IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());
        Collections.shuffle(sourceNumbers);
        this.numbers = sourceNumbers.subList(0, 6);
    }

    public int getMatch(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
