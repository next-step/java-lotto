package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {

    private final RandomNumberStrategy randomNumberStrategy;
    private final List<Integer> numbers;

    public RandomNumbersGenerator(RandomNumberStrategy randomNumberStrategy, List<Integer> numbers) {
        this.randomNumberStrategy = randomNumberStrategy;
        this.numbers = numbers;
    }

    public List<Integer> createRandomNumbers() {
        shuffleSavedNumbers();
        return this.randomNumberStrategy.getRandomNumbers(numbers);
    }

    private void shuffleSavedNumbers() {
        Collections.shuffle(numbers);
    }
}
