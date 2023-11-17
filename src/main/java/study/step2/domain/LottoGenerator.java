package study.step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static final int POOL_START_NUMBER = 1;
    public static final int POOL_END_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final Random random;
    private List<Integer> numberPool = new ArrayList<>();

    public LottoGenerator(Random random) {
        this.random = random;
        this.numberPool = pooling();
    }

    private List<Integer> pooling() {
        return IntStream.rangeClosed(POOL_START_NUMBER, POOL_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    public Lotto generate() {
        Collections.shuffle(numberPool, random);
        List<Integer> lottoNumbers = numberPool.subList(0, LOTTO_NUMBERS_SIZE);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

}
