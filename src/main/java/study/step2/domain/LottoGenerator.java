package study.step2.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final LottoNumbers lottoNumbers;
    private final Random random;

    public LottoGenerator(Random random) {
        this.random = random;
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto generate() {
        List<Integer> pool = lottoNumbers.pool();
        Collections.shuffle(pool, random);
        IntStream.range(0, LOTTO_NUMBERS_SIZE).forEach(n -> pickAndAddNumber(pool));
        lottoNumbers.sort();
        return new Lotto(lottoNumbers);
    }

    private void pickAndAddNumber(List<Integer> pool) {
        Integer pickedNumber = pool.remove(0);
        lottoNumbers.add(pickedNumber);
    }
}
