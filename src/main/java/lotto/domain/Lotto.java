package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        numbers = Numbers.getAutoNumbers();
    }

    public Lotto(List<Integer> answer) {
        Numbers.valid(answer);
        numbers = new ArrayList<>(answer);
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    public int matchCount(Lotto ticket) {
        return (int) ticket.getNumbers().stream()
                .filter(this.numbers::contains)
                .count();
    }
}
