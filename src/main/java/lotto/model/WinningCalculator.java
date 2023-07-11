package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCalculator {

    public static final int DEFAULT_VALUE = 0;

    public Map<Rank, Integer> calculate(WinningLotto winningLotto, PurChasedLotto purChasedLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        initializeRankMap(result);
        List<Lotto> lottos = purChasedLotto.getLottos();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.compare(lotto);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private void initializeRankMap(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            result.put(rank, DEFAULT_VALUE);
        }
    }
}
