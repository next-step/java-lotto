package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
        List<Integer> copyList = new ArrayList<>(allList);
        Collections.shuffle(copyList, new Random());
        return new Lotto(copyList.subList(0, count));
    }
}
