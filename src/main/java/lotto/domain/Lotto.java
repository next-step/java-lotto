package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }

    public int match(Lotto lotto) {
        return (int) lotto.getLotto().stream().filter(number -> contains(number)).count();
    }
}
