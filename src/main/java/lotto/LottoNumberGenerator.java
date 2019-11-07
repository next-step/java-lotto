package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final List<Integer> NUMBER_POOL = IntStream.range(1, 46)
                                                              .boxed()
                                                              .collect(Collectors.toList());

    public static List<Integer> sixNumberGenerator() {
        Collections.shuffle(NUMBER_POOL);
        return NUMBER_POOL.stream()
                          .limit(6)
                          .collect(Collectors.toList());
    }
}
