package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public long compareCount(Lotto others) {
        return others.numbers.stream()
                .filter(other -> numbers.contains(other))
                .count();
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers + "";
    }
}
