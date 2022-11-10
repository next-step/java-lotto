package lotto.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.List;

public class RandomNumberStrategy implements LottoNumberStrategy {

    private static final int MIN_IDX = 0;
    private static final int COUNT = 6;
    private static final List<LottoNumber> lottoNumbers = LottoNumbers.getLottoNumbers();

    @Override
    public List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(MIN_IDX, COUNT);
    }
}
