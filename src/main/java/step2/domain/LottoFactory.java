package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private final LottoGenerateStrategy strategy;
    private final List<List<Integer>> numbers = new ArrayList<>();

    public LottoFactory(LottoGenerateStrategy strategy) {
        this.strategy = strategy;
    }

    public List<List<Integer>> generateLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> generate = strategy.generate();
            numbers.add(new ArrayList<>(generate));
        }

        return numbers;
    }
}
