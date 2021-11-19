package step2.domain.starategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.domain.Lotto.BOUND_NUMBER;
import static step2.domain.Lotto.SIZE;

public class RandomGetLottoImpl implements GetLottoNumberStrategy{

    @Override
    public List<Integer> getLotto() {
        Collections.shuffle(BOUND_NUMBER);
        List<Integer> lottoNumbers = new ArrayList<>(BOUND_NUMBER.subList(0, SIZE));
        return lottoNumbers;
    }
}
