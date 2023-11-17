package study.step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static final int POOL_START_NUMBER = 1;
    public static final int POOL_END_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> lottoNumbers;
    private final Random random;

    public LottoGenerator(Random random) {
        this.random = random;
        this.lottoNumbers = new ArrayList<>();
    }

    public Lotto generate() {
        List<Integer> pool = pool();
        Collections.shuffle(pool, random);
        IntStream.range(0, LOTTO_NUMBERS_SIZE)
            .forEach(n -> pickAndAdd(pool));
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public List<Integer> pool() {
        return IntStream.rangeClosed(POOL_START_NUMBER, POOL_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    private void pickAndAdd(List<Integer> pool) {
        lottoNumbers.add(pool.remove(0));
    }
}
