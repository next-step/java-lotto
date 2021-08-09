package lotto.domain;

import java.util.*;

public class RandomNumGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_MAX_NUM = 44;

    private final List<Integer> randomNumbers;

    public RandomNumGenerator() {
        this.randomNumbers = new ArrayList<>();
    }

    @Override
    public List<Integer> generateNumber() {
        while (randomNumbers.size() < LOTTO_NUMBERS_COUNT) {
            int random = RANDOM.nextInt(LOTTO_MAX_NUM) + 1;
            if (!validDuplicate(random)) {
                randomNumbers.add(random);
            }
        }
        return randomNumbers;
    }

    private boolean validDuplicate(int i) {
        return randomNumbers.contains(i);
    }
}
