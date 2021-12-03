package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final Numbers numbers;

    public Lotto() {
        numbers = new Numbers();
        numbers.marked();
    }

    public Lotto(List<Integer> answer) {
        numbers = new Numbers(answer);
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = this.numbers.getNumbers();
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    public int matchCount(Lotto ticket) {
        return (int) ticket.getNumbers().stream()
                .filter(this.numbers::contains)
                .count();
    }
}
