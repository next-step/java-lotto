package lotto.model;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;


    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
