package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public long countHits(List<Integer> others) {
        return others.stream()
                .filter(other -> numbers.contains(other))
                .count();
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers + "";
    }
}
