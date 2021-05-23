package lotto.lotto;

import java.util.Set;

public class Answer {
    Set<Integer> numbers;

    public Answer(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> numbers() {
        return numbers;
    }
}
