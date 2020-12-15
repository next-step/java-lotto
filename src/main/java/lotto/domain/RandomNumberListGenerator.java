package lotto.domain;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberListGenerator implements NumberListGenerator {
    private final Random random = new Random();

    @Override
    public Set<Integer> generate() {
        return random
                .ints(Lotto.LOTTO_NUMBER_SIZE, Lotto.MIN_NUMBER, Lotto.MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toSet());
    }
}
