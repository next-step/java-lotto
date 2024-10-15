package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    private final Random random;

    public RandomNumberGenerator(Random random) {
        this.random = new Random();
    }

    public List<Integer> generate(int count, int bound) {
        Set<Integer> numberSet = new HashSet<>();

        int indexCorrection = 1;
        while(numberSet.size() < count) {
            numberSet.add(random.nextInt(bound) + indexCorrection);
        }

        return new ArrayList<>(numberSet);
    }
}
