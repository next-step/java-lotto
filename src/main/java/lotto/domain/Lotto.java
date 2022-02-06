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

    public boolean hasNumber(Integer value) {
        return this.numbers.contains(value);
    }
}
