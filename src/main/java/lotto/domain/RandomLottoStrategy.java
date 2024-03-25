package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoStrategy implements LottoGenerateStrategy{

    private static final int FROM_INDEX = 0;
    private static final int LAST_INDEX = 6;

    @Override
    public LottoNumbers generateLottoNumbers(List<Integer> lottoNumberPool) {
        Collections.shuffle(lottoNumberPool);
        List<Integer> pickLottoNumbers = new ArrayList<>(lottoNumberPool.subList(FROM_INDEX, LAST_INDEX));
        Collections.sort(pickLottoNumbers);
        return new LottoNumbers(pickLottoNumbers);
    }
}
