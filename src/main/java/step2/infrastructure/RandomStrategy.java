package step2.infrastructure;

import step2.domain.LottoGenerateStrategy;

import java.util.*;
import java.util.stream.IntStream;

public class RandomStrategy implements LottoGenerateStrategy {
    private final List<Integer> numberList = new ArrayList<>();
    private final int amount;

    public RandomStrategy(int amount) {
        IntStream.rangeClosed(1, 45)
                .forEach(numberList::add);

        this.amount = amount;
    }

    @Override
    public List<List<Integer>> generate() {
        List<List<Integer>> numbers = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Collections.shuffle(numberList);
            numbers.add(new ArrayList<>(numberList.subList(0, 6)));
        }
        return numbers;
    }
}
