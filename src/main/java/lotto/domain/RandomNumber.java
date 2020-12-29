package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomNumber {
    public static final int SUBLIST_START_INDEX = 0;
    public static final int SUBLIST_END_INDEX = 6;
    private final LottoNumber lottoNumber = new LottoNumber();

    public List<Number> getLottoNumbers() {
        return lottoNumber.getNumberRange();
    }

    public List<Number> createRandomNumbers(LottoNumber lottoNumber) {
        Collections.shuffle(getLottoNumbers());
        return lottoNumber.getNumberRange().subList(SUBLIST_START_INDEX, SUBLIST_END_INDEX);
    }

}
