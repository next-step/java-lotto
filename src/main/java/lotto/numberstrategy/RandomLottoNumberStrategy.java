package lotto.numberstrategy;

import java.util.Collections;
import java.util.List;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    int LOTTO_NUMBER_SELECT_COUNT = 0;

    @Override
    public List<Integer> createNumber() {
        Collections.shuffle(LOTTO_NUMBER_LIST);
        return LOTTO_NUMBER_LIST.subList(0, LOTTO_NUMBER_SELECT_COUNT);
    }
}
