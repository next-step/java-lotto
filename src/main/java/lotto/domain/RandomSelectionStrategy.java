package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;

public class RandomSelectionStrategy implements LottoNumberSelectionStrategy {
    private final static ArrayList<Integer> LOTTO_NUMBER_CONTAINERS = createLottoNumberContainer();
    private final static RandomSelectionStrategy INSTANCE = new RandomSelectionStrategy();

    public static RandomSelectionStrategy getInstance() {
        return INSTANCE;
    }

    private static ArrayList<Integer> createLottoNumberContainer() {
        ArrayList<Integer> container = new ArrayList<>();
        for (int i = LottoNumber.MIN_BOUND; i < LottoNumber.MAX_BOUND + 1; i++) {
            container.add(i);
        }
        return container;
    }

    @Override
    public LottoNumbers select() {
        Collections.shuffle(LOTTO_NUMBER_CONTAINERS);
        return LottoNumbers.valueOf(LOTTO_NUMBER_CONTAINERS.subList(0, LottoNumbers.LOTTO_NUMBERS_CARDINALITY));
    }
}
