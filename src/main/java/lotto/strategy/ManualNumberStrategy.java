package lotto.strategy;

import java.util.ArrayList;
import java.util.List;

public class ManualNumberStrategy implements NumberStrategy {

    private final List<Integer> numbers;

    public ManualNumberStrategy(List<Integer> inputNumbers) {
        this.numbers = new ArrayList<>(inputNumbers);
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }
}
