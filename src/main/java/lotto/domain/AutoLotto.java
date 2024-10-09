package lotto.domain;

import java.util.Collections;
import java.util.List;

public class AutoLotto implements LottoStrategy {
    private AutoLotto() {
    }

    private static AutoLotto INSTANCE = null;

    public static AutoLotto getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AutoLotto();
        }
        return INSTANCE;
    }

    @Override
    public Lotto getLotto(List<Integer> allList, int count) {
        Collections.shuffle(allList);
        return new Lotto(allList.subList(0, count));
    }
}
