package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    private static final int LOTTO_NUMBER_SELECT_COUNT = 6;
    private List<Integer> lottoNumList;
    private static final int LOTTO_TOTAL_COUNT = 45;

    public RandomLottoNumberStrategy() {
        lottoNumList = new ArrayList<>(LOTTO_TOTAL_COUNT);
        for (int i = 1; i <= LOTTO_TOTAL_COUNT; i++) {
            lottoNumList.add(i);
        }
    }

    @Override
    public List<Integer> createNumber() {
        Collections.shuffle(lottoNumList);
        return new ArrayList<>(lottoNumList.subList(0, LOTTO_NUMBER_SELECT_COUNT));
    }
}
