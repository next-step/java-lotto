package lotto.lottogenerator;

import java.util.Collections;
import java.util.List;

public class LottoNumGeneratorByAuto implements LottoNumGeneratorStrategy {
    private static final int LOTTO_SIZE = 6;

    public LottoNumGeneratorByAuto() {
    }

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = LottoNumberPool.makePool();
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}