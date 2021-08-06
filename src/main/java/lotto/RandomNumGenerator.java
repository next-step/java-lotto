package lotto;

import java.util.*;

public class RandomNumGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_MAX_NUM = 44;


    private final Set<Integer> randomNumbers;

    public RandomNumGenerator() {
        this.randomNumbers = new HashSet<>();
    }

    @Override
    public Set<Integer> generateNumber() {
        while (randomNumbers.size() < LOTTO_NUMBERS_COUNT) {
            randomNumbers.add(RANDOM.nextInt(LOTTO_MAX_NUM) + 1);
        }
        return Collections.unmodifiableSet(randomNumbers);
    }

}
