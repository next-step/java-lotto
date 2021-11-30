package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    private static final int LOTTO_NUMBER_SELECT_COUNT = 6;

    @Override
    public List<Integer> createNumber() {
        Collections.shuffle(LOTTO_NUMBER_LIST);
        return LOTTO_NUMBER_LIST.subList(0, LOTTO_NUMBER_SELECT_COUNT);
    }
}
