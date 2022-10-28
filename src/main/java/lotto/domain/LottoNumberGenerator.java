package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int RANGE_BEGIN_NUMBER = 1;
    private static final int RANGE_END_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private static final List<Integer> LOTTO_RANGE_NUMBERS = IntStream.range(RANGE_BEGIN_NUMBER, RANGE_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> generate() {
        Collections.shuffle(LOTTO_RANGE_NUMBERS);
        return LOTTO_RANGE_NUMBERS.stream()
                .limit(NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
