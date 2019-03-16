package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto implements Lotto {
    private List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }
}
