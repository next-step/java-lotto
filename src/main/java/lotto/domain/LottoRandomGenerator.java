package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.toList;

public class LottoRandomGenerator implements RandomGenerator {
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 45;
    private static final Integer SELECTING_COUNT = 6;

    @Override
    public List<Integer> randomNumbers() {
        List<Integer> candidates = IntStream.rangeClosed(MIN_NUM, MAX_NUM)
                .boxed()
                .collect(toList());
        shuffle(candidates);

        return IntStream.range(0, SELECTING_COUNT)
                .mapToObj(candidates::get)
                .collect(toList());
    }
}
