package study.step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static study.step2.domain.LottoNumber.LOTTO_END_NUMBER;
import static study.step2.domain.LottoNumber.LOTTO_START_NUMBER;

public class LottoGenerator {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    private List<Integer> numberPool = new ArrayList<>();

    public LottoGenerator() {
        this.numberPool = pooling();
    }

    private List<Integer> pooling() {
        return IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    public Lotto generate() {
        Collections.shuffle(numberPool);
        List<Integer> lottoNumbers = numberPool.subList(0, LOTTO_NUMBERS_SIZE);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

}
