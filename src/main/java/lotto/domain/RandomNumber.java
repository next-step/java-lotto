package lotto.domain;

import util.CommonConstants;

import java.util.Collections;
import java.util.List;

public class RandomNumber {
    private final LottoNumber lottoNumber = new LottoNumber();

    public List<Number> getLottoNumbers() {
        return lottoNumber.getNumberRange();
    }

    public List<Number> createRandomNumbers() {
        Collections.shuffle(getLottoNumbers());
        return lottoNumber.getNumberRange().subList(CommonConstants.NUMBER_LENGTH_MIN, CommonConstants.NUMBER_LENGTH_MAX);
    }
}
