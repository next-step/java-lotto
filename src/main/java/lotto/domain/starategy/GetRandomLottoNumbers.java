package lotto.domain.starategy;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.BOUND_NUMBERS;
import static lotto.domain.Lotto.SIZE;

public class GetRandomLottoNumbers implements GetLottoNumbersStrategy {
    @Override
    public List<Number> getLotto() {
        Collections.shuffle(BOUND_NUMBERS);
        List<Number> lottoNumbers = new ArrayList<Number>(BOUND_NUMBERS.subList(0, SIZE));
        return lottoNumbers;
    }
}
