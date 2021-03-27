package lotto.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int START = 0;
    private static final int END = 6;
    private static final List<Integer> AUTO_LOTTO = IntStream.rangeClosed(1, 45).mapToObj(Integer::new).collect(Collectors.toList());

    private LottoGenerator() {
    }

    private static class LazyHolder {
        private static final LottoGenerator instance = new LottoGenerator();
    }

    public static LottoGenerator getInstance() {
        return LazyHolder.instance;
    }

    public Set<Integer> generateShuffledNumbers() {
        Collections.shuffle(AUTO_LOTTO);
        return new TreeSet(AUTO_LOTTO.subList(START, END)
                .stream()
                .collect(Collectors.toSet()));
    }
}
