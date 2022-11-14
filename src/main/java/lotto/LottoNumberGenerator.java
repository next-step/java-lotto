package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumberGenerator {
    private static final List<Integer> LOTTO_NUMBERS;

    private LottoNumberGenerator() {

    }

    static {
        LOTTO_NUMBERS = IntStream.range(1, 46)
                 .boxed()
                 .collect(Collectors.toList());
    }

    public static List<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> newLotto = LOTTO_NUMBERS.subList(0, 6);
        Collections.sort(newLotto);
        return List.copyOf(newLotto);
    }
}
