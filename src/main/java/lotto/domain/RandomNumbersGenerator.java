package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {

    private final List<Integer> numbers;

    public RandomNumbersGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> createRandomNumbers(RandomNumberStrategy randomNumberStrategy) {
        shuffleSavedNumbers();
        return randomNumberStrategy.getRandomNumbers(numbers);
    }

    private void shuffleSavedNumbers() {
        Collections.shuffle(numbers);
    }
}
