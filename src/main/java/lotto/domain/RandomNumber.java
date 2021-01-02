package lotto.domain;

import util.CommonConstants;

import java.util.Collections;
import java.util.List;

public class RandomNumber {

    public List<Number> createRandomNumbers() {
        List<Number> numbers = LottoNumber.collectionLottoNumbers();
        Collections.shuffle(numbers);
        return numbers.subList(CommonConstants.NUMBER_LENGTH_MIN, CommonConstants.NUMBER_LENGTH_MAX);
    }
}
