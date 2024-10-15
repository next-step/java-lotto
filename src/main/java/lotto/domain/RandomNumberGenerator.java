package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    private final Random random;

    public RandomNumberGenerator(Random random) {
        this.random = random;
    }

    public List<Integer> generate(int count, int lowerBound, int upperBound) {
        Set<Integer> numberSet = new HashSet<>();

        while(numberSet.size() < count) {
            numberSet.add(random.nextInt(upperBound) + lowerBound);
        }

        return new ArrayList<>(numberSet);
    }
}
