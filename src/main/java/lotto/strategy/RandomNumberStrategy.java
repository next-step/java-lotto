package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberStrategy implements LottoNumberStrategy {

    private static final int START = 1;
    private static final int END = 45;
    private static final int MIN_IDX = 0;
    private static final int COUNT = 6;

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        for (int i = START; i <= END; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
    }

    @Override
    public List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(MIN_IDX, COUNT);
    }
}
