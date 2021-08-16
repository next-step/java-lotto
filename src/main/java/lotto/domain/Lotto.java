package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Number> numbers = new ArrayList<>();

    public Lotto(List<Number> shuffleNumbers) {
        Collections.sort(shuffleNumbers);
        numbers.addAll(shuffleNumbers);
    }

    public List<Number> numbers() {
        return this.numbers;
    }

    public int match(List<Number> winnerNumbers) {
        return (int) numbers.stream()
                .filter(winnerNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
