package model;

import java.util.List;

public class LottoGame {
    private List<Integer> numbers;

    public LottoGame(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
