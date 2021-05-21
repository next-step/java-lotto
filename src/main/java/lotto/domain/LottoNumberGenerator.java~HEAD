package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final List<Integer> SAMPLE = IntStream.rangeClosed(Lotto.MIN, Lotto.MAX)
            .boxed()
            .collect(Collectors.toList());

    private LottoNumberGenerator() {
    }

    public static List<Integer> get() {
        List<Integer> shuffle = new ArrayList<>(SAMPLE);
        Collections.shuffle(shuffle);
        shuffle = shuffle.subList(0, Lotto.SIZE);
        shuffle.sort(Integer::compareTo);
        return shuffle;
    }
}
