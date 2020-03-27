package lotto;

import java.util.Collections;
import java.util.List;

public class LottoNumGeneratorByAuto implements LottoNumGeneratorStrategy {
    public LottoNumGeneratorByAuto() {
    }

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = LottoNumberPool.makePool();
        Collections.shuffle(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
