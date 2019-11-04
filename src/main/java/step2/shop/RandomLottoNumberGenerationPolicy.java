package step2.shop;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RandomLottoNumberGenerationPolicy implements LottoNumberGenerationPolicy {
    private static final int NUMBER_SIZE = 6;
    private static final int NUMBER_LOWER_BOUND = 1;
    private static final int NUMBER_UPPER_BOUND = 45;

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    RandomLottoNumberGenerationPolicy() {
    }

    @Override
    public List<Integer> nextSix() {
        return Stream.generate(() -> random.nextInt(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND + 1))
                     .limit(NUMBER_SIZE)
                     .collect(Collectors.toList());
    }
}
