package lotto.domain.starategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.BOUND_NUMBERS;
import static lotto.domain.Lotto.SIZE;

public class RandomGetLottoImpl implements GetLottoNumberStrategy{

    @Override
    public List<Integer> getLotto() {
        Collections.shuffle(BOUND_NUMBERS);
        List<Integer> lottoNumbers = new ArrayList<>(BOUND_NUMBERS.subList(0, SIZE));
        return lottoNumbers;
    }
}
