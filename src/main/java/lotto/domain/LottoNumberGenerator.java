package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final List<Integer> ALL_LOTTO_NUMBER = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    private static final int FROM = 0;
    private static final int TO = 6;

    public static List<Integer> generate() {
        Collections.shuffle(ALL_LOTTO_NUMBER);
        return ALL_LOTTO_NUMBER.subList(FROM, TO);
    }

}
