package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {
    private final static int BOUND = 45;
    private final List<Integer> randomNumbers;

    public RandomUtil() {
        randomNumbers = new ArrayList<>();

        for (int i = 1; i < BOUND; i++) {
            randomNumbers.add(i);
        }
    }

    public List<Integer> generateNumbers() {
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0,6);
    }
}
