package lotto.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int START = 0;
    private static final int END = 6;
    private final List<Integer> AUTO_LOTTO = IntStream.rangeClosed(1, 45).mapToObj(Integer::new).collect(Collectors.toList());

    private LottoGenerator() {
    }

    private static class LazyHolder {
        private static final LottoGenerator instance = new LottoGenerator();
    }

    public static LottoGenerator getInstance() {
        return LazyHolder.instance;
    }

    public int[] generateShuffledNumbers() {
        Collections.shuffle(AUTO_LOTTO);
        return AUTO_LOTTO.subList(START, END)
                .stream()
                .mapToInt(i->i)
                .toArray();
    }
}
