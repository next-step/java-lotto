package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator implements LottoNumberGenerator {
    private final List<Integer> ALL_LOTTO_NUMBER = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private static final int PICK_NUMBER_COUNT = 6;

    public LottoNumber create() {
        Collections.shuffle(ALL_LOTTO_NUMBER);
        List<Integer> randomNumber = ALL_LOTTO_NUMBER.stream()
                .limit(PICK_NUMBER_COUNT)
                .sorted()
                .collect(Collectors.toList());
        return new LottoNumber(randomNumber);
    }
}
