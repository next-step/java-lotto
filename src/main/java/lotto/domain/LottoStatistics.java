package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<Integer, Integer> statistics = new HashMap<>();

    public LottoStatistics() {
        statistics.put(0, 0);
        statistics.put(1, 0);
        statistics.put(2, 0);
        statistics.put(3, 0);
        statistics.put(4, 0);
        statistics.put(5, 0);
        statistics.put(6, 0);
    }

    public void check(MyLottos myLottos, WinningLotto winningLotto) {
        myLottos.getLottos().forEach(lotto -> {
            addMatchCount(winningLotto.matchCount(lotto));
        });
    }

    private void addMatchCount(int matchCount) {
        statistics.put(matchCount, statistics.get(matchCount) + 1);
    }

    public int getMatchCount(int matchCount) {
        return statistics.get(matchCount);
    }
}
