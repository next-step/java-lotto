package step2.domain;

import java.util.Collections;
import java.util.Map;

public class WinningStatistics {

    private final Map<Integer, Lottos> winningStatistics;

    public WinningStatistics(Map<Integer, Lottos> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public int winningLottosCount(int matchCount) {
        return winningLottos(matchCount).size();
    }

    private Lottos winningLottos(int matchCount) {
        if (exist(matchCount)) {
            return winningStatistics.get(matchCount);
        }

        return new Lottos(Collections.emptyList());
    }

    private boolean exist(int matchCount) {
        return winningStatistics.containsKey(matchCount);
    }

}
