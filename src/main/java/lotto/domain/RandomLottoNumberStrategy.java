package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    private static final int LOTTO_NUMBER_SELECT_COUNT = 6;
    private static List<Integer> LOTTO_NUMBER_LIST;
    private static final int LOTTO_TOTAL_COUNT = 45;

    public RandomLottoNumberStrategy() {
        LOTTO_NUMBER_LIST = new ArrayList<>(LOTTO_TOTAL_COUNT);
        for (int i = 1; i <= LOTTO_TOTAL_COUNT; i++) {
            LOTTO_NUMBER_LIST.add(i);
        }
    }

    @Override
    public List<Integer> createNumber() {
        Collections.shuffle(LOTTO_NUMBER_LIST);
        return LOTTO_NUMBER_LIST.subList(0, LOTTO_NUMBER_SELECT_COUNT);
    }
}
