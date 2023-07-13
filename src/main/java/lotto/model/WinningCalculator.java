package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCalculator {

    private static final int DEFAULT_VALUE = 0;

    public WinningResult calculate(final WinningLotto winningLotto,
        final PurChasedLotto purChasedLotto) {
        Map<Rank, Integer> result = initializeRankMap();
        List<Lotto> lottos = purChasedLotto.getLottos();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.compare(lotto);
            result.put(rank, result.get(rank) + 1);
        }
        return new WinningResult(result);
    }

    private Map<Rank, Integer> initializeRankMap() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, DEFAULT_VALUE);
        }
        return result;
    }
}
