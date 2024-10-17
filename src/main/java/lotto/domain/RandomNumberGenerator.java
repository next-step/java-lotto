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
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("하한값, 상한값을 확인해 주세요.");
        }

        Set<Integer> numberSet = new HashSet<>();

        int correctionValue = 1;
        while(numberSet.size() < count) {
            numberSet.add(random.nextInt(upperBound - lowerBound + correctionValue) + lowerBound);
        }

        return new ArrayList<>(numberSet);
    }
}
