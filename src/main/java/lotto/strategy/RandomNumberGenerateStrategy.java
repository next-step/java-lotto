package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy{

    private final List<Integer> numbers;

    public RandomNumberGenerateStrategy() {
        this(newInstance());
    }

    public RandomNumberGenerateStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private static List<Integer> newInstance() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0 ; i <= 45 ; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    @Override
    public List<Integer> generateNumber() {
        shuffle();
        return this.numbers.subList(0, 6);
    }

    private void shuffle() {
        Collections.shuffle(this.numbers);
    }
}
