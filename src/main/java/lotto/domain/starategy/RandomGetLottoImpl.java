package lotto.domain.starategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.BOUND_NUMBER;
import static lotto.domain.Lotto.SIZE;

public class RandomGetLottoImpl implements GetLottoNumberStrategy{

    @Override
    public List<Integer> getLotto() {
        Collections.shuffle(BOUND_NUMBER);
        List<Integer> lottoNumbers = new ArrayList<>(BOUND_NUMBER.subList(0, SIZE));
        return lottoNumbers;
    }
}
