package lotto.domain;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberListGenerator implements NumberListGenerator {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final Random random = new Random();

    @Override
    public Set<Integer> generate() {
        return random
                .ints(LOTTO_NUMBER_SIZE, MIN_NUMBER, MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toSet());
    }
}
