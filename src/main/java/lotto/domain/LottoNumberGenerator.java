package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private LottoNumberGenerator() {
    }

    public static Lotto generate() {

        List<Integer> numbers = IntStream.rangeClosed(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> selected = numbers.subList(0, LOTTO_SIZE);
        Collections.sort(selected);

        return new Lotto(selected);
    }
}
