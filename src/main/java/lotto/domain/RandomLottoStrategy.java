package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoStrategy implements LottoGenerateStrategy{

    public static final int FROM_INDEX = 0;
    public static final int LAST_INDEX = 6;
    private final List<Integer> lottoNumberPool;

    public RandomLottoStrategy(List<Integer> lottoNumberPool) {
        this.lottoNumberPool = lottoNumberPool;
    }

    @Override
    public LottoNumbers generateLottoNumbers() {
        Collections.shuffle(lottoNumberPool);
        List<Integer> pickLottoNumbers = new ArrayList<>(lottoNumberPool.subList(FROM_INDEX, LAST_INDEX));
        Collections.sort(pickLottoNumbers);
        return new LottoNumbers(pickLottoNumbers);
    }
}
