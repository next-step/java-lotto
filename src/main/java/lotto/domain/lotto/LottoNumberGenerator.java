package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final List<Integer> numbers = IntStream.range(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

    private LottoNumberGenerator() {
    }

    public static List<Integer> getNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream().limit(Lotto.NUMBER_COUNT).collect(Collectors.toList());
    }
}
