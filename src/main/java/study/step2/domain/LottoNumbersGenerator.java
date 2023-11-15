package study.step2.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    public static final int LOTTO_NUMBER_SIZE = 6;
    private final LottoNumbers lottoNumbers;
    private final Random random;

    public LottoNumbersGenerator(Random random) {
        this.random = random;
        this.lottoNumbers = new LottoNumbers(new ArrayList<>());
    }

    public LottoNumbers generate() {
        List<Integer> pool = lottoNumbers.pool();
        Collections.shuffle(pool, random);
        IntStream.range(0, LOTTO_NUMBER_SIZE)
            .forEach(n -> pickAndAddNumber(pool));
        lottoNumbers.sort();
        return lottoNumbers;
    }

    private void pickAndAddNumber(List<Integer> pool) {
        Integer pickedNumber = pool.remove(0);
        lottoNumbers.add(pickedNumber);
    }
}
