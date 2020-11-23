package step2.domain;

import java.util.List;

public class Lotto {
    private Integer[] numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.toArray(new Integer[numbers.size()]);
    }

    public Integer[] getNumbers() {
        return this.numbers;
    }
}
