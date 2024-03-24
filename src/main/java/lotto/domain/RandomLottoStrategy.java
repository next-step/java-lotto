package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoStrategy implements LottoGenerateStrategy{

    private final List<Integer> lottoNumberPool;

    public RandomLottoStrategy(List<Integer> lottoNumberPool) {
        this.lottoNumberPool = lottoNumberPool;
    }

    @Override
    public LottoNumbers generateLottoNumbers() {
        Collections.shuffle(lottoNumberPool);
        List<Integer> pickLottoNumbers = new ArrayList<>(lottoNumberPool.subList(0, 6));
        Collections.sort(pickLottoNumbers);
        return new LottoNumbers(pickLottoNumbers);
    }
}
