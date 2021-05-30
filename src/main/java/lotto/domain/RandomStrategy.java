package lotto.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomStrategy implements Strategy {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int GENERATE_COUNT = 6;

    Set<Integer> numbers = new HashSet<>();

    @Override
    public Set<Integer> generateNumbers() {
        for (int i = 0; i < GENERATE_COUNT; i++) {
            addNumber();
        }
        return numbers;
    }

    private void addNumber() {
        int number = generateNumber();
        while ( numbers.contains(number)) {
            number =  generateNumber();
        }
        numbers.add(number);
    }

    public Integer generateNumber() {
        return new Random().nextInt(MAX_NUMBER)+MIN_NUMBER;
    }
}
