package lotto.domain;

import util.CommonConstants;

import java.util.Collections;
import java.util.List;

public class RandomNumber {

    public List<Number> createRandomNumbers() {
        Collections.shuffle(LottoNumber.collectionLottoNumbers());
        return LottoNumber.collectionLottoNumbers().subList(CommonConstants.NUMBER_LENGTH_MIN, CommonConstants.NUMBER_LENGTH_MAX);
    }
}
