package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toUnmodifiableList());
    }

    public long countMatches(List<Integer> winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
