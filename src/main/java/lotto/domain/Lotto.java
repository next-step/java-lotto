package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matches(List<Integer> winNumbers) {
        return (int) numbers.stream()
                .filter(winNumbers::contains)
                .count();
    }
}
