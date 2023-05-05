package lotto.domain;

import java.util.List;

public class ManualNumberCreation implements NumberCreationStrategy {

    private List<List<Integer>> numbers;

    public ManualNumberCreation(List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<List<Integer>> getNumbers() {
        return numbers;
    }
}
