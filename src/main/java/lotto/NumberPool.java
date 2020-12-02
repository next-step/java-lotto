package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPool {

    protected static final int LOWER_BOUND = 1;

    protected static final int UPPER_BOUND = 45;

    protected static final int START_INCLUSIVE = 0;

    private static final List<Integer> numberPool = makePool();

    private static List<Integer> makePool() {
        return IntStream.range(LOWER_BOUND, UPPER_BOUND).boxed().collect(Collectors.toList());
    }

    public static Set<Integer> getLottoNumbers() {
        Collections.shuffle(numberPool);
        return IntStream.range(START_INCLUSIVE, LottoMachine.LOTTO_SIZE).boxed()
                .collect(Collectors.toSet());
    }
}
