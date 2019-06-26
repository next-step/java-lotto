package lotto.domain;

import java.util.List;

public class Lotto {

    static final int AMOUNT = 1000;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
