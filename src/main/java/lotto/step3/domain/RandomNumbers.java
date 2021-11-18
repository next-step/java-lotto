package lotto.step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class RandomNumbers {

    private static final int LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> indices = createIndices();

    private static List<Integer> createIndices() {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            indices.add(i);
        }
        return indices;
    }

    public static List<Integer> createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != LOTTO_SIZE) {
            int randomIndex = new Random().nextInt(LOTTO_NUMBER - 1) + 1;
            addNotDuplicateNumbers(numbers, randomIndex);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    private static void addNotDuplicateNumbers(List<Integer> numbers, int randomIndex) {
        if (!numbers.contains(indices.get(randomIndex))) {
            numbers.add(indices.get(randomIndex));
        }
    }

}
