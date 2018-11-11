package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public int getLottoCount(int budget) {
        int countByBudget = budget/1000;
        return countByBudget;
    }

    public List<Lotto> makeLotto(int budget) {
        int countByBudget = getLottoCount(budget);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < countByBudget; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
