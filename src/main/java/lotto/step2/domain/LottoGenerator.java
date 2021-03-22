package lotto.step2.domain;

import java.util.stream.IntStream;

public class LottoGenerator {

    private final int[] AUTO_LOTTO = IntStream.rangeClosed(1, 45).toArray();

    private LottoGenerator() {
    }

    private static class LazyHolder {
        private static final LottoGenerator instance = new LottoGenerator();
    }

    public static LottoGenerator getInstance() {
        return LazyHolder.instance;
    }
}
