package step2.domain.starategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.domain.Lotto.NumberList;
import static step2.domain.Lotto.SIZE;

public class RandomGetLottoImpl implements GetLottoNumberStrategy{

    @Override
    public List<Integer> getLotto() {
        Collections.shuffle(NumberList);
        List<Integer> lottoNumbers = new ArrayList<>(NumberList.subList(0, SIZE));
        return lottoNumbers;
    }
}
